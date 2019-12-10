package com.gpdi.service;

import com.gpdi.entity.User;
import java.util.List;
import java.util.Map;

public interface UserService {

    public int addUser(User user);
    /**
     * @description:增加一条用户信息
     */

    /**
     * @description:删除一条用户信息
     */
    public int deleteUserById(int id);

    /**
     * @descpription:通过id查询用户信息
     */
    public User getUserById(int id);

    /**
     * @description:增加一条用户信息
     */

    public int updateUser(User user);


    /**
     * @descrpition:分页查询
     */
    public List<User> getUserList(String place);

    /**
     *
     * @description:通过sql查询用户信息
     */
    public List<User> getUserListBySql(String sql);

    List<Map<Integer, String>> selOrdersState();
}
