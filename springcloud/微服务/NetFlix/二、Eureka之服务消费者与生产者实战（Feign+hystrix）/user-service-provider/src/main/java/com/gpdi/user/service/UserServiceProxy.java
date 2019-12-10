package com.gpdi.user.service;

import com.gpdi.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceProxy implements UserService {
    @Override
    public boolean saveUser(User user) {
        String sql = "insert into user values(null,#{" + user.getName() + "})";
        if (jdbcTemplate.update(sql) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<User> getAllUser() {
        return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper(User.class));
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

}
