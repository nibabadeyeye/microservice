package com.gpdi.web.video.mapper;

import com.gpdi.web.video.entity.Nature;
import com.gpdi.web.video.entity.Room;
import com.gpdi.web.video.entity.RoomUtil;
import java.util.List;
public interface RoomMapper {
    /**
     * @desc: 查询提出申请，查询当前专家的房间数: 小于3代表可以创建房间，否则的话不能创建房间
     */
    public int getRoomNumberByNatureId(String natureId);

    /**
     * @desc: 用户离开房间，当前房间销毁
     */
    public void delRoomByUserId(RoomUtil roomUtil);


    /**
     * @desc:查询排队人员
     **/
    public Room getRoomByNature(String natureId);

    /**
     * 用户创建一个房间
     */
    public void userCreateRoom(Room room);

    /**
     *
     * @desc:查询创建房间的所有房间号
     *
     * */
    public List<Room> getAllRoomByNatureId(String id);

    /**
     *
     * @desc:修改正在视频的人员状态
     * */
    public void updateRoomFlag(int id);

    /**
     *
     * @desc:查询当前是否有人员等待专家进入下一视频
     *
     * */
    public int getWaitNaturePeople(String natureId);

    /**
     *
     * @desc:查询当前房间是否已经
     */
    public int judgeRoomHasCreate(String sql);

    /**
     *
     * @desc:删除之前的房间
     */
    public void delHistoryRoom(String sql);

    /**
     * @desc:查询当前第一个专家
     */
    public String getFirstNatureId();

    /**
     * @desc:获取所有的专家信息
     *
     */

    public List<Nature> getAllNatureList();

}
