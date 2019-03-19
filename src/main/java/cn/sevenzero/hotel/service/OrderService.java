package cn.sevenzero.hotel.service;

import cn.sevenzero.hotel.pojo.Order;
import cn.sevenzero.hotel.utils.HotelResult;

import java.util.List;

/**
 * @作者: 姜帆
 * @创建日期: 2018/9/14 11:39
 * @功能描述:
 */
public interface OrderService {
    /**
     *
     * @param userPhone
     * @return
     */
    HotelResult findOrdersByUserPhone(String userPhone);

    /**
     *
     * @return
     */
    HotelResult findOrders();
}