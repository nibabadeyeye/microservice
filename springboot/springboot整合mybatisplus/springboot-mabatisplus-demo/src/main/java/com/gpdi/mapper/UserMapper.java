package com.gpdi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gpdi.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {

    public List<User> getUserListBySql(String sql);


    List<Map<Integer, String>> selOrdersState();
}
