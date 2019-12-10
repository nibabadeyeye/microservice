package com.whs.springBootAnnotation.dao;


import com.whs.springBootAnnotation.domain.UserEntity;
import com.whs.springBootAnnotation.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;
//ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//    JdbcTemplate jdbcTemplate  =  (JdbcTemplate) context.getBean("jdbcTemplate");


    public List<UserEntity> getAll()
    {
        String sql="select * from t_myuser";
         return  this.jdbcTemplate.query(sql,new UserMapper());
    }
}
