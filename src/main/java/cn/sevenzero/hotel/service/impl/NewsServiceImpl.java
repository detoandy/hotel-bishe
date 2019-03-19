package cn.sevenzero.hotel.service.impl;

import cn.sevenzero.hotel.mapper.NewsMapper;
import cn.sevenzero.hotel.pojo.News;
import cn.sevenzero.hotel.service.NewsService;
import cn.sevenzero.hotel.utils.HotelResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @作者: 26706
 * @创建日期: 2018/9/3 16:36
 * @功能描述:
 */
@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public HotelResult selectNewArticles() {
        List<News> list = newsMapper.selectNewArticles();

        if (list != null && list.size() > 0) {
            return HotelResult.ok(list);
        } else {
            return HotelResult.build(400,"数据为空");
        }

    }
}
