package cn.sevenzero.hotel.service.impl;

import cn.sevenzero.hotel.mapper.OrderMapper;
import cn.sevenzero.hotel.pojo.Order;
import cn.sevenzero.hotel.service.OrderService;
import cn.sevenzero.hotel.utils.Common;
import cn.sevenzero.hotel.utils.HotelResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @作者: 姜帆
 * @创建日期: 2018/9/14 11:40
 * @功能描述:
 */
@Transactional
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public HotelResult findOrdersByUserPhone(String userPhone) {
        List<Order> list= orderMapper.selectOrdersByUserPhone(userPhone);
        HotelResult result=Common.wrapService(list,null,new HotelResult(),1);
        return result;
    }

    @Override
    public HotelResult findOrders() {
        List<Order> list=orderMapper.selectOrders();
        HotelResult result=Common.wrapService(list,null,new HotelResult(),1);
        return result;
    }
}