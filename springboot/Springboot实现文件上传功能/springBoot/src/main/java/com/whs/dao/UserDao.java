package com.whs.dao;

import com.whs.pojo.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserDao {
    //查询所有
    @Select("select id,name,age,sex from T_USER")
    public List<UserEntity> queryList();
    //查询一个
    @Select("select id,name,age,sex from T_USER where id=#{id}")
    public UserEntity queryOne(int id);
    //修改一个
    @Update("update T_USER set name=#{name},age=#{age},sex=#{sex} where id=#{id}")
    public void update(UserEntity userEntity);
    //增加
    @Insert("insert into T_USER values(null,#{name},#{age},#{sex})")
    public void save(UserEntity userEntity);
    //删除
    @Delete("delete from T_USER where id=#{id}")
    public void deleteUser(int id);

}
