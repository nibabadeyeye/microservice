package com.gpdi.web.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gpdi.web.user.entity.User;
import com.gpdi.web.user.entity.WeiChatLogin;

public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据id查询用户信息
     */

    public User getUserByOpenId(String id);

    /**
     * 增加用户
     */
    public void addUser(User user);

    /**
     * 修改用户信息
     */
    public void updateUser(User use);

    /**
     * 查询openID是否存在
     */
    public int countOpenId(String openId);

    /**
     * 添加用户
     **/
    public void addWeiChatUser(WeiChatLogin weiChatLogin);

    /**
     * 查询用户身份信息，是否在专家里面有该用户
     * */
    public int judgeIsNature(String uid);

    /**
     *
     *  修改正在视频的人员状态
     *
     * */
    public void updateRoomFlag(int id);
}
