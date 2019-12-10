package com.whs.controller;

import com.whs.util.LinklistUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkListController {
    @Autowired
    LinklistUtil linklistUtil;
    @GetMapping(value="/addLinkList")
    public void add()
    {
        linklistUtil.add();
    }
}
