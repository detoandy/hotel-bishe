package cn.sevenzero.hotel.mapper;

import cn.sevenzero.hotel.pojo.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 */
public interface OrderMapper {
    /**
     * 根据用户手机号查询用户订单列表
     *
     * @param userPhone
     * @return
     */
    @Select("select yu.mtel as USER_PHONE,yu.id as O_ID,yu.tel as USER_TEL, \n" +
            "yu.name as  OCCUPANT_NAME,\n" +
            "yu.state as PAYMENT_STATE,yu.bdate as START_DATE,\n" +
            "yu.edate as EXPIRY_DATE,ji.name as HOTEL_NAME,\n" +
            "yu.fangkuan as  PAYMENT_AMOUNT,\n" +
            "ke.name as ROOM_TYPE,\n" +
            "yu.count as ROOM_COUNT\n" +
            "from yuding yu,jiudian ji,kefang ke \n" +
            "where yu.fang=ke.id \n" +
            "and ke.jid=ji.id \n" +
            "and mtel=#{userPhone}")
    List<Order> selectOrdersByUserPhone(String userPhone);


    @Select("select yu.id as O_ID,yu.tel as USER_TEL, \n" +
            "yu.name as  OCCUPANT_NAME,\n" +
            "yu.state as PAYMENT_STATE,yu.bdate as START_DATE,\n" +
            "yu.edate as EXPIRY_DATE,ji.name as HOTEL_NAME,\n" +
            "yu.fangkuan as  PAYMENT_AMOUNT,\n" +
            "ke.name as ROOM_TYPE,\n" +
            "yu.count as ROOM_COUNT\n" +
            "from yuding yu,jiudian ji,kefang ke \n" +
            "where yu.fang=ke.id \n" +
            "and ke.jid=ji.id"
           )
    List<Order> selectOrders();
}