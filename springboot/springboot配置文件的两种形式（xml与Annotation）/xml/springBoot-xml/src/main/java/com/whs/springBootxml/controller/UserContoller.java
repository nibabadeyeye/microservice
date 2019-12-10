package com.whs.springBootxml.controller;
import com.whs.springBootxml.dao.UserDao;
import com.whs.springBootxml.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.Element;
import java.util.List;

@RestController
public class UserContoller {

    Element e;


    @Autowired
    private UserDao userDao;

    @GetMapping("/getAll")
    public List<UserEntity> getAll()
    {
        return this.userDao.getAll();
    }
}
