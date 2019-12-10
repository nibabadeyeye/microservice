package com.whs.springBootAnnotation.mapper;


import com.whs.springBootAnnotation.domain.UserEntity;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserMapper implements RowMapper<UserEntity> {
    @Override
    public UserEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        int uid = resultSet.getInt("uid");
        String uname = resultSet.getString("uname");
        String upassword = resultSet.getString("upassword");
        UserEntity user = new UserEntity();
        user.setUid(uid);
        user.setUname(uname);
        user.setUpassword(upassword);
        return user;

    }
}
