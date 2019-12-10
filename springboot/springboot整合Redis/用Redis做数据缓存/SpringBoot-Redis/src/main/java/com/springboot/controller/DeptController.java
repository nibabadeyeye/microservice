package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Dept;
import com.springboot.service.DeptService;

/**
* @author 作者 yaolijian
* @version 创建时间：2018年12月17日 上午10:06:15
* 类说明
*/
@RestController
public class DeptController {
   
	@Autowired
	private DeptService deptService;

	/*根据id查询*/
	@GetMapping(value="/dept/get/{id}")
	public  Dept get(@PathVariable("id") Long id) {
		return deptService.get(id);
	}
	
	/*全查*/
	@GetMapping(value="/dept/list")
	public List<Dept> list(){
		return deptService.findAll();
	}
}
