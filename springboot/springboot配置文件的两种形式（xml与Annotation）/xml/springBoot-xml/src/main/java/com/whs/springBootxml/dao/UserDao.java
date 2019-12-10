package com.whs.springBootxml.dao;

import com.whs.springBootxml.domain.UserEntity;
import com.whs.springBootxml.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserDao {


     ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
     JdbcTemplate jdbcTemplate  =  (JdbcTemplate) context.getBean("jdbcTemplate");

    public List<UserEntity> getAll()
    {
        String sql="select * from t_myuser";
         return  this.jdbcTemplate.query(sql,new UserMapper());
    }
}
