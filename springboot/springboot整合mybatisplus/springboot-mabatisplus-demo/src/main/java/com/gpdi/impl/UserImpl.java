package com.gpdi.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gpdi.mapper.UserMapper;
import com.gpdi.entity.User;
import com.gpdi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class UserImpl implements UserService {
    @Override
    public List<Map<Integer, String>> selOrdersState() {
        return userMapper.selOrdersState();
    }

    @Override
    public User getUserById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteUserById(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public List<User> getUserList(String place) {
        QueryWrapper<User>wrapper=new QueryWrapper<>();
        wrapper.eq("place",place);
        return userMapper.selectList(wrapper);
    }

    public List<User> getUserListBySql(String sql) {

        return this.userMapper.getUserListBySql(sql);

    }

    @Autowired
    UserMapper userMapper;


}
