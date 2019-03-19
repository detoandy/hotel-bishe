package cn.sevenzero.hotel.service;

import cn.sevenzero.hotel.utils.HotelResult;

/**
 * @作者: 26706
 * @创建日期: 2018/9/3 16:36
 * @功能描述:
 */
public interface NewsService {
    /**
     * 查询最新的10条文章
     * @return
     */
    HotelResult selectNewArticles();
}
