package com.whs.controller;

import com.whs.util.HashSanLieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HashSanLieController {
    @Autowired
    HashSanLieUtil  hashSanLieUtil;
    @GetMapping(value="/hashSanLieUtil")
    public void add()
    {
        hashSanLieUtil.addObject();
    }
}
