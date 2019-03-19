package cn.sevenzero.hotel.service;

import cn.sevenzero.hotel.pojo.JiuDian;
import cn.sevenzero.hotel.utils.HotelAndGuestRoom;
import cn.sevenzero.hotel.utils.HotelResult;

import java.util.List;

/**
 * @作者: 26706
 * @创建日期: 2018/9/3 15:32
 * @功能描述:
 */
public interface JiuDianService {
    /**
     *  查询酒店最新的 n 条记录
     * @return
     */
    HotelResult findNewHotels();

    /**
     * 根据酒店pojo中的条件查询 酒店列表
     * @param hotelAndGuestRoom 用户输入的查询条件
     * @return 返回
     */
    HotelResult findHotelsByPojo(HotelAndGuestRoom hotelAndGuestRoom);

    /**
     * 根据酒店id查询酒店
     * @param id
     * @return
     */
    HotelResult findHotelById(Integer id);

    /**
     * 新建酒店
     * @param jiuDian
     */
    void createHotel(JiuDian jiuDian) throws Exception;

    /**
     * 移除酒店
     * @param id
     */
    void removeHotel(Integer id) throws Exception;

    /**
     * 修改酒店
     * @param jiuDian
     */
    void editHotel(JiuDian jiuDian) throws Exception;

    /**
     * 查询酒店
     * @param hotelName
     * @return
     */
    HotelResult findHotelByName(String hotelName);
}
