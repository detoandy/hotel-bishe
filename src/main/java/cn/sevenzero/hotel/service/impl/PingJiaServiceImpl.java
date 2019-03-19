package cn.sevenzero.hotel.service.impl;

import cn.sevenzero.hotel.mapper.PingJiaMapper;
import cn.sevenzero.hotel.pojo.PingJia;
import cn.sevenzero.hotel.service.PingJiaService;
import cn.sevenzero.hotel.utils.Common;
import cn.sevenzero.hotel.utils.HotelResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @作者: 姜帆
 * @创建日期: 2018/9/13 10:53
 * @功能描述:
 */
@Service
@Transactional
public class PingJiaServiceImpl implements PingJiaService {

    @Autowired
    private PingJiaMapper pingJiaMapper;

    @Override
    public  List<PingJia> selectEvaluateByHId(Integer hotelId) {
        List<PingJia> list= pingJiaMapper.selectEvaluateByHId(hotelId);
        return list;
    }
}
