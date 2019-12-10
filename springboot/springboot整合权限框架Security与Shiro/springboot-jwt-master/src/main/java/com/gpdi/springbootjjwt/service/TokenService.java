package com.gpdi.springbootjjwt.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gpdi.springbootjjwt.entity.User;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
/**
 * @author jinbin
 * @date 2018-07-08 21:04
 */
@Service("TokenService")
public class TokenService {
    public String getToken(User user) {
        String token = JWT
                .create().withAudience(user.getId())// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMDD HH:mm:ss");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 1);
        Date expireDate = calendar.getTime();//设置过期时间
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        System.out.println("当前时间是" + date + "  过期时间是" + expireDate);
        //加密Token
        String token1 = JWT.create()
                .withHeader(map)
                .withAudience("rrrrr")
                .withClaim("username", "whs")
                .withClaim("password", "123")
                .withExpiresAt(expireDate)//设置过期时间
                .withIssuedAt(date)  //设置签发时间
                .sign(Algorithm.HMAC256("test"));//设置秘钥
        System.out.println("加密的Token" + token1);
        String token2 = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6IjEyMyIsImV4cCI6MTU1NzMwMTk5MCwiaWF0IjoxNTU3MzAxOTMwLCJ1c2VybmFtZSI6IndocyJ9.2aJvG_MlV-nrdJAJ30lS078q7P2Kw9xafaDojJA5yqA";
        //解密Token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("test")).build();
        DecodedJWT decodedJWT = null;
        try {
            decodedJWT = jwtVerifier.verify(token1);
            Map mapp = decodedJWT.getClaims();
            Object username = mapp.get("username");//加密后的用户名，加密不可逆
            Object password = mapp.get("password");//加密后的密码，加密不可逆
            Date d = decodedJWT.getExpiresAt();//jwt过期时间
            String kk = JWT.decode(token1).getAudience().get(0);
            System.out.println("系统的用户名为" + kk);
            System.out.println("用户名" + username + " 密码" + password + "  过期时间" + expireDate.getTime() + "   现在时间" + new Date().getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
