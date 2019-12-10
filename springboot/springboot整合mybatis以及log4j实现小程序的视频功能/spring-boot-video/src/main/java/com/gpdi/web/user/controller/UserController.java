package com.gpdi.web.user.controller;
import com.gpdi.util.ResponseData;
import com.gpdi.web.user.entity.User;
import com.gpdi.web.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
@RestController
@RequestMapping("/user")
@Validated
public class UserController {


    @RequestMapping(value = {"/login"}, method = {RequestMethod.POST})
    public ResponseData login(@NotNull(message = "code不能为空") String code, User user, HttpServletRequest request) {
        return userService.login(code, user, request);
    }
    @RequestMapping(value="getUserByToken")
    public ResponseData getUserByToken(HttpServletRequest request){
        String token = request.getHeader("X-iEnvPro-Token");
        User user = (User) request.getServletContext().getAttribute(token);
        String userId = user.getUid();
        return new ResponseData(200,"请求成功",userId);
    }
    @Autowired
    private UserService userService;
}
