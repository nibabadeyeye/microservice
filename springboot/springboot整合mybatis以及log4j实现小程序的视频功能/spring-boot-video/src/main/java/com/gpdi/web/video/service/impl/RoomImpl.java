package com.gpdi.web.video.service.impl;

import com.gpdi.web.video.entity.Nature;
import com.gpdi.web.video.entity.Room;
import com.gpdi.web.video.entity.RoomUtil;
import com.gpdi.web.video.mapper.RoomMapper;
import com.gpdi.web.video.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomImpl implements RoomService {
    @Override
    public List<Nature> getAllNatureList() {
        return this.roomMapper.getAllNatureList();
    }

    @Override
    public int judgeRoomHasCreate(String sql) {
      return roomMapper.judgeRoomHasCreate(sql);

    }

    @Override
    public String getFirstNatureId() {
        return this.roomMapper.getFirstNatureId();
    }

    @Override
    public void delHistoryRoom(String sql) {
        this.roomMapper.delHistoryRoom(sql);
    }

    @Override
    public int getWaitNaturePeople(String natureId) {
        return roomMapper.getWaitNaturePeople(natureId);
    }

    @Override
    public void updateRoomFlag(int id) {
        roomMapper.updateRoomFlag(id);
    }

    @Override
    public Room getRoomByNature(String natureId) {
        return roomMapper.getRoomByNature(natureId);
    }

    @Override
    public void userCreateRoom(Room room) {
        roomMapper.userCreateRoom(room);
    }

    @Override
    public List<Room> getAllRoomByNatureId(String id) {
        return roomMapper.getAllRoomByNatureId(id);
    }

    @Override
    public int getRoomNumberByNatureId(String natureId) {
        return roomMapper.getRoomNumberByNatureId(natureId);
    }

//    @Override
//    public void delRoomByUserId(String roomId, String userId) {
//        roomMapper.delRoomByUserId(roomId, userId);
//    }

    @Override
    public void delRoomByUserId(RoomUtil roomUtil) {
        roomMapper.delRoomByUserId(roomUtil);
    }

    @Autowired
    private RoomMapper roomMapper;


}
