package com.gpdi.web.user.service;

import com.gpdi.util.ResponseData;
import com.gpdi.web.user.entity.User;
import javax.servlet.http.HttpServletRequest;


public interface UserService {

    /*
       登录
    */
    public ResponseData login(String code, User user, HttpServletRequest request);

    /**
     * @desc: 查询当前人员身份
     */
    public User getUserNature(HttpServletRequest httpServletRequest);

    /**
     *判断是否为专家
     *
     */

    public int judgeIsNature(String uid);

}
