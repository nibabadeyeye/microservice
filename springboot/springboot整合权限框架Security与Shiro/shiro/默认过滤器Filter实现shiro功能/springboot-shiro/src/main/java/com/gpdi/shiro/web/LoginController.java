package com.gpdi.shiro.web;

import com.gpdi.shiro.util.ResponseData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {

    @RequestMapping(value = "/login")
    @ResponseBody
    public ResponseData login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return new ResponseData(201, "登录失败，未知账户");
        } catch (IncorrectCredentialsException ice) {
            return new ResponseData(201, "登录失败，密码不正确");
        } catch (LockedAccountException lae) {
            return new ResponseData(201, "登录失败，账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            return new ResponseData(201, "登录失败，用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            return new ResponseData(201, "登录失败，用户名或密码不正确");
        }
        if (subject.isAuthenticated()) {
            return new ResponseData(200, "登录成功");
        } else {
            token.clear();
            return new ResponseData(201, "登录失败,请重新登录！");

        }
    }

}
