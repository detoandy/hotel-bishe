package cn.sevenzero.hotel.service;

import cn.sevenzero.hotel.pojo.KeFang;
import cn.sevenzero.hotel.pojo.Room;
import cn.sevenzero.hotel.utils.HotelResult;

/**
 * @功能描述:
 */
public interface RoomService {

    HotelResult getRoomList(String name);

    HotelResult getRoomById(Integer id);

    void saveRoom(Room room);

    void updateRoom(Room room);

    void deleteRoomById(Integer id);

    Integer getCount();


    /**
     *
     * @param roomName
     * @return
     */
    HotelResult queryGuestRoomByRoomName(String roomName);


}