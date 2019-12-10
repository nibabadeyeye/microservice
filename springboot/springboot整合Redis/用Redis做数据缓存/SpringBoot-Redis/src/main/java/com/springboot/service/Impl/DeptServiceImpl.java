package com.springboot.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.springboot.entity.Dept;
import com.springboot.mapper.DeptDao;
import com.springboot.service.DeptService;

/**
 * @author 作者 yaolijian
 * @version 创建时间：2018年12月17日 上午10:07:26 类说明
 */
@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao deptDao;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	@Autowired
	private RedisTemplate<String, List<Dept>> redisListTemplate;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	/*
	 * redisTemplate.opsForValue();//操作字符串 redisTemplate.opsForHash();//操作hash
	 * redisTemplate.opsForList();//操作list redisTemplate.opsForSet();//操作set
	 * redisTemplate.opsForZSet();//操作有序set
	 */

	@Override
	public Dept get(Long id) {
		String ids = String.valueOf(id);
		
		if (redisTemplate.opsForValue().get(ids) != null) {
			log.info("从缓存获取信息");
			return (Dept) redisTemplate.opsForValue().get(ids);
		}
		else {
			log.info("从数据库获取信息");
			Dept dept = deptDao.findById(id);
			redisTemplate.opsForValue().set(ids, dept);
			return dept;
		}
	}

	@Override
	public List<Dept> findAll() {
		List<Dept>test=new ArrayList<>();
		if (redisTemplate.opsForList().range("all",0,-1).size()!=0) {
			log.info("从缓存获取信息");
			//return redisListTemplate.opsForList().;
			List list=new ArrayList();
			list=redisListTemplate.opsForList().range("all",0,-1);
			test=list;
			return test;

		}
		else {
			log.info("从数据库获取信息");
			List<Dept> deptList = deptDao.findAll();
			//redisListTemplate.opsForList().set("all", deptList);
		//	redisListTemplate.opsForList().leftPush("all",deptList);
			//redisListTemplate.leftPush("zcylist",list)
			//redisListTemplate.opsForList().set("all",1111111111,deptList);
			redisListTemplate.opsForList().leftPush("all",deptList);
			return deptList;
		}



		//return deptList;
	}

}
