package cn.sevenzero.hotel.service;

import cn.sevenzero.hotel.pojo.PingJia;
import cn.sevenzero.hotel.utils.HotelResult;

import java.util.List;

/**
 * @作者: 26706
 * @创建日期: 2018/9/13 10:53
 * @功能描述:
 */
public interface PingJiaService {
    List<PingJia> selectEvaluateByHId(Integer hotelId);
}