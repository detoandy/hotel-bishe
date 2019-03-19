package cn.sevenzero.hotel.service.impl;

import cn.sevenzero.hotel.mapper.JiuDianMapper;
import cn.sevenzero.hotel.utils.HotelAndGuestRoom;
import cn.sevenzero.hotel.pojo.JiuDian;
import cn.sevenzero.hotel.service.JiuDianService;
import cn.sevenzero.hotel.utils.HotelResult;
import cn.sevenzero.hotel.utils.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @����: ����
 * @��������: 2018/9/3 15:33
 * @��������:
 */
@Service
@Transactional
public class JiuDianServiceImpl implements JiuDianService {

    private final Logger logger= LoggerFactory.getLogger(JiuDianServiceImpl.class);

    @Autowired
    private JiuDianMapper jiuDianMapper;

    @Override
    public HotelResult findNewHotels() {
        List<JiuDian> list=jiuDianMapper.selectNewHotels();
        HotelResult result= Common.wrapService(list,null,new HotelResult(),1);
        return result;// �޸����
    }

    @Override
    public HotelResult findHotelsByPojo(HotelAndGuestRoom hotelAndGuestRoom) {
        int pageNo=hotelAndGuestRoom.getPageNo();//�õ��û�ҳ��
        pageNo=10*(pageNo-1); // �������ݿ�ʼλ��
        if(pageNo<0){
            pageNo=0;//�뻧û�д�ҳ�����ҳ��Ϊ����
        }
        // ������ѯ��������
        if(!"".equals(hotelAndGuestRoom.getRen())){
           hotelAndGuestRoom.parseNumberOfPeople(hotelAndGuestRoom.getRen());
        }
        if(!"".equals(hotelAndGuestRoom.getPrice())){
            hotelAndGuestRoom.parseRoomPrice(hotelAndGuestRoom.getPrice());
        }
        List<JiuDian> list= jiuDianMapper.selectHotelsByPojo(hotelAndGuestRoom,pageNo);
        HotelResult result= Common.wrapService(list,hotelAndGuestRoom,new HotelResult(),hotelAndGuestRoom.getPageNo());// ��װ�����ҵ��
        return result;
    }

    @Override
    public HotelResult findHotelById(Integer id) {
        JiuDian jiuDian= jiuDianMapper.selectHotelById(id);
        HotelResult result=Common.wrapService(jiuDian,null,new HotelResult(),1);
        return  result;
    }

    @Override
    public void createHotel(JiuDian jiuDian) {
        jiuDianMapper.insertHotel(jiuDian);
    }

    @Override
    public void removeHotel(Integer id) {
        jiuDianMapper.deleteHotel(id);
    }

    @Override
    public void editHotel(JiuDian jiuDian) {
        jiuDianMapper.updateHotel(jiuDian);
    }

    @Override
    public HotelResult findHotelByName(String hotelName) {
        List<JiuDian> list= jiuDianMapper.selectHotelByName(hotelName);
        HotelResult result= Common.wrapService(list,hotelName,new HotelResult(),1);
        return result;
    }

}