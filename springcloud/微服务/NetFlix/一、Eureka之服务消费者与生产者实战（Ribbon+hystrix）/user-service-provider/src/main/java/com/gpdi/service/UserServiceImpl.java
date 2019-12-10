package com.gpdi.service;

import com.gpdi.user.entity.User;
import com.gpdi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) {
        System.out.println("添加成功" + user);
        String name = user.getName();
        String sql = "insert into user values(null,#{" + name + "})";
        jdbcTemplate.execute(sql);

    }

    @Override
    public List<User> getAllUser() {

        return jdbcTemplate.query("select * from user ", new BeanPropertyRowMapper(User.class));

    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

}
