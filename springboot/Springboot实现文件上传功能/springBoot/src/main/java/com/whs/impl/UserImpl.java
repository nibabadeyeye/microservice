package com.whs.impl;

import com.whs.dao.UserDao;
import com.whs.pojo.UserEntity;
import com.whs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public List<UserEntity> queryUserList() {
        return userDao.queryList();
    }

    @Override
    public void addUser(UserEntity user) {
       userDao.save(user);
    }

    @Override
    public void deleteUser(int id) {
      userDao.deleteUser(id);
    }

    @Override
    public void updateUser(UserEntity user) {
      userDao.update(user);
    }

    @Override
    public UserEntity queryOne(int id) {
       return  userDao.queryOne(id);
    }
}
