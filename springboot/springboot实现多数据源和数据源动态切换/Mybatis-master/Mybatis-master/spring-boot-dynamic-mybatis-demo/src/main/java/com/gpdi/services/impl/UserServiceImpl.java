package com.gpdi.services.impl;

import com.gpdi.domain.UserInfo;
import com.gpdi.mapper.UserInfoMapper;
import com.gpdi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YHYR on 2017-12-25
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getUserInfo() {
        return userInfoMapper.getUserInfo();
    }
}
