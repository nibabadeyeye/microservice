博客地址：https://www.jianshu.com/p/e88d3f8151db

一、什么是jwt

       全称：json web token ，是一种基于json格式进行加密的客户端和服务端的传递信息

二、jwt的核心内容有哪些？

     主要包含了三部分：

          一、头部

           {
             "alg": "HS256", //声明加密的算法:通常直接使用 HMAC SHA256
             "typ": "JWT"    //加密类型：jwt
           }

          二、Payload
            载荷就是存放有效信息的地方。
            有效信息包含三个部分
            1.标准中注册的声明
            2.公共的声明
            3.私有的声明
            标准中注册的声明 (建议但不强制使用) ：
            iss: jwt签发者
            sub: 面向的用户(jwt所面向的用户)
            aud: 接收jwt的一方
            exp: 过期时间戳(jwt的过期时间，这个过期时间必须要大于签发时间)
            nbf: 定义在什么时间之前，该jwt都是不可用的.
            iat: jwt的签发时间
            jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。



         三、Signature

          jwt的第三部分是一个签证信息，这个签证信息由三部分组成：
          header (base64后的)
          payload (base64后的)
          secret
          这个部分需要base64加密后的header和base64加密后的payload使用.连接组成的字符串，然后通过header中声明的加密方式进行加盐secret组合加密，然后就构成了jwt的第三部分。
          密钥secret是保存在服务端的，服务端会根据这个密钥进行生成token和进行验证，所以需要保护好。


三、jwt的系统流程

        1. 用户使用账号和面发出post请求；

        2. 服务器使用私钥创建一个jwt；

        3. 服务器返回这个jwt给浏览器；

        4. 浏览器将该jwt串在请求头中像服务器发送请求；

        5. 服务器验证该jwt；

        6. 返回响应的资源给浏览器。

