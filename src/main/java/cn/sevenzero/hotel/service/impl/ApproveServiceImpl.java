package cn.sevenzero.hotel.service.impl;

import cn.sevenzero.hotel.mapper.ApproveMapper;
import cn.sevenzero.hotel.pojo.Approve;
import cn.sevenzero.hotel.service.ApproveService;
import cn.sevenzero.hotel.utils.Common;
import cn.sevenzero.hotel.utils.HotelResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 */
@Service
public class ApproveServiceImpl implements ApproveService {

    @Autowired
    private ApproveMapper approveMapper;

    @Override
    public HotelResult getApproveList() {
        List<Approve> list = approveMapper.getApproveList();
        HotelResult result = Common.wrapService(list,null,new HotelResult(),1);
        return result;
    }
}
