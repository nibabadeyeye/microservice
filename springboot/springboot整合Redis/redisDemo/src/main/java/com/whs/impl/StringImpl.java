package com.whs.impl;

import com.whs.util.StringUtil;
import com.whs.service.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StringImpl implements StringService {
    @Autowired
    private StringUtil userDao;


    @Override
    public void addUser(String key,String value) {
        this.userDao.addUser(key,value);
    }

    @Override
    public void deleteUser(String key) {
      this.userDao.deleteUser(key);
    }

    @Override
    public void updateUser(String key,String value) {
        this.userDao.update(key,value);

    }

    @Override
    public String queryOne(String key) {
        return userDao.queryOne(key);
    }
}
