package cn.sevenzero.hotel.service;

import cn.sevenzero.hotel.utils.HotelResult;

/**
 */
public interface NewsService {
    /**
     * 查询最新的10条文章
     * @return
     */
    HotelResult selectNewArticles();
}
