package cn.sevenzero.hotel.service.impl;

import cn.sevenzero.hotel.mapper.RoomMapper;
import cn.sevenzero.hotel.pojo.KeFang;
import cn.sevenzero.hotel.pojo.Room;
import cn.sevenzero.hotel.service.RoomService;
import cn.sevenzero.hotel.utils.HotelResult;
import cn.sevenzero.hotel.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @作者: 26706
 * @创建日期: 2018/9/7 15:12
 * @功能描述:
 */
@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public HotelResult getRoomList(String name) {
        List<Room> roomList = roomMapper.findRoomListByName(name);
        HotelResult result= Common.wrapService(roomList,null,new HotelResult(),1);
        return result;
    }

    @Override
    public HotelResult getRoomById(Integer id) {
        Room room = roomMapper.getRoomById(id);
        HotelResult result= Common.wrapService(room,null,new HotelResult(),1);
        return result;
    }

    @Override
    public void saveRoom(Room room) {
        roomMapper.saveRoom(room);
    }

    @Override
    public void updateRoom(Room room) {
        roomMapper.updateRoom(room);
    }

    @Override
    public void deleteRoomById(Integer id) {
        roomMapper.deleteRoomById(id);
    }

    @Override
    public Integer getCount() {
        return roomMapper.getCount();
    }



    @Override
    public HotelResult queryGuestRoomByRoomName(String roomName) {
        List<KeFang> list= roomMapper.selectGuestRoomByRoomName(roomName);
        HotelResult result=Common.wrapService(list,roomName,new HotelResult(),1);
        return result;
    }
}