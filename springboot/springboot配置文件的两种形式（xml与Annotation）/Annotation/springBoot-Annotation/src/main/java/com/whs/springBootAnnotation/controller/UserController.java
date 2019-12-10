package com.whs.springBootAnnotation.controller;

import com.whs.springBootAnnotation.dao.UserDao;
import com.whs.springBootAnnotation.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    private UserDao userDao;
    @GetMapping("getAll")
    public List<UserEntity> getAll(){
        return this.userDao.getAll();
    }
}
