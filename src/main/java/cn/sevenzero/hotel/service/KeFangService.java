package cn.sevenzero.hotel.service;

import cn.sevenzero.hotel.pojo.KeFang;
import cn.sevenzero.hotel.utils.HotelResult;

/**
 * @作者: 26706
 * @创建日期: 2018/9/7 15:11
 * @功能描述:
 */
public interface KeFangService {
    /**
     *
     * @param hotelId
     * @return
     */
    HotelResult selectGuestRoomsByHId(Integer hotelId);

    /**
     *
     * @param id
     * @return
     */
    HotelResult selectGuestRoomsById(Integer id);

    /**
     *
     * @param keFang
     * @param hotelId
     */
    void createGuestRoom(KeFang keFang,Integer hotelId) throws Exception;

    /**
     *
     * @param keFang
     */
    void updateGuestRoom(KeFang keFang) throws Exception;


    void removeGuestRoom(Integer id) throws Exception;

    /**
     *
     * @param roomName
     * @return
     */
    HotelResult queryGuestRoomByRoomName(String roomName);
}