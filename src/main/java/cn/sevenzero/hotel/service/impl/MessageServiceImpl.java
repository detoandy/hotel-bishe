package cn.sevenzero.hotel.service.impl;

import cn.sevenzero.hotel.mapper.MessageMapper;
import cn.sevenzero.hotel.pojo.Message;
import cn.sevenzero.hotel.service.MessageService;
import cn.sevenzero.hotel.utils.HotelResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @作者: 26706
 * @创建日期: 2018/9/3 17:04
 * @功能描述:
 */
@Transactional
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public HotelResult selectNewMessages() {
        List<Message> list = messageMapper.selectNewMessages();

        if (list != null && list.size() > 0) {
            return HotelResult.ok(list);
        } else {
            return HotelResult.build(400, "数据为空");
        }
    }
}
