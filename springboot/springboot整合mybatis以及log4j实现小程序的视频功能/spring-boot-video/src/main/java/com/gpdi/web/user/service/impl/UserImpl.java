package com.gpdi.web.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gpdi.util.MiniProgramHelper;
import com.gpdi.util.ResponseData;
import com.gpdi.web.user.entity.User;
import com.gpdi.web.user.mapper.UserMapper;
import com.gpdi.web.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @Auther: Kevin Cui
 * @Date: 2018/11/6 18
 * @Description:
 */


@Service
public class UserImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserMapper userDao;

    @Override
    public User getUserNature(HttpServletRequest httpServletRequest) {
        return null;
    }

    @Override
    public int judgeIsNature(String uid) {
        return userDao.judgeIsNature(uid);
    }

    @Override
    public ResponseData login(@NotNull(message = "code不能为空") String code, User user, HttpServletRequest request) {
        //查询openID是否存在

        String result = new MiniProgramHelper().jscode2Session(code);
        logger.info("登录: " + result + "  code" + code);
        JSONObject obj = JSONObject.parseObject(result);
        //拿到程序的openID
        String openid = obj.getString("openid");


        //查询用户是否存在，不存在则将当前的用户信息存入数据库
        User u = userDao.getUserByOpenId(openid);
        if (u == null) {
            u = new User();
            u.setUid(openid);
            u.setNickName(user.getNickName());
            u.setAvatarUrl(user.getAvatarUrl());
            u.setGender(user.getGender());
            u.setProvince(user.getProvince());
            u.setCity(user.getCity());
            u.setCountry(user.getCountry());
            userDao.addUser(u);
        } else {
            u.setNickName(user.getNickName());
            u.setAvatarUrl(user.getAvatarUrl());
            u.setGender(user.getGender());
            u.setProvince(user.getProvince());
            u.setCity(user.getCity());
            u.setCountry(user.getCountry());
            userDao.updateUser(u);
        }

        String token = UUID.randomUUID().toString();
        request.getSession().getServletContext().setAttribute(token, u);
        return new ResponseData(200, "success", token);

    }
}
