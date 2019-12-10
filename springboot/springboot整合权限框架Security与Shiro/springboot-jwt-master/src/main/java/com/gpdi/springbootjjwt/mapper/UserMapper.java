package com.gpdi.springbootjjwt.mapper;

import com.gpdi.springbootjjwt.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author jinbin
 * @date 2018-07-08 20:44
 */
public interface UserMapper {

    User findByUsername(@Param("username") String username);

    User findUserById(@Param("Id") String Id);
}
