package cn.sevenzero.hotel.service.impl;

import cn.sevenzero.hotel.mapper.KeFangMapper;
import cn.sevenzero.hotel.pojo.KeFang;
import cn.sevenzero.hotel.service.KeFangService;
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
public class KeFangServiceImpl implements KeFangService {

    @Autowired
    private KeFangMapper keFangMapper;

    @Override
    public HotelResult selectGuestRoomsByHId(Integer hotelId) {
        List<KeFang> list= keFangMapper.selectGuestRoomsByHId(hotelId);
        HotelResult result= Common.wrapService(list,null,new HotelResult(),1);
        return result;
    }

    @Override
    public HotelResult selectGuestRoomsById(Integer id) {
        KeFang keFang= keFangMapper.selectGuestRoomsById(id);
        HotelResult result=Common.wrapService(keFang,"数据为空");
        return result;
    }

    @Override
    public void createGuestRoom(KeFang keFang, Integer hotelId) {
        keFangMapper.insertGuestRoom(keFang,hotelId);
    }

    @Override
    public void updateGuestRoom(KeFang keFang) {
        keFangMapper.updateGuestRoom(keFang);
    }

    @Override
    public void removeGuestRoom(Integer id) throws Exception {
        keFangMapper.deleteGuestRoom(id);
    }

    @Override
    public HotelResult queryGuestRoomByRoomName(String roomName) {
        List<KeFang> list= keFangMapper.selectGuestRoomByRoomName(roomName);
        HotelResult result=Common.wrapService(list,roomName,new HotelResult(),1);
        return result;
    }
}