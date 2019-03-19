package cn.sevenzero.hotel.mapper;

import cn.sevenzero.hotel.pojo.News;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @作者: 26706
 * @创建日期: 2018/9/3 16:36
 * @功能描述: 新闻mapper
 */
public interface NewsMapper {
    /**
     * 查询最新10 条文章
     * @return
     */
    @Select("SELECT  " +
                 "n.id,n.title," +
                 "n.date,n.info," +
                 "n.appuser,n.pic " +
            "FROM news n " +
            "ORDER BY date DESC " +
            "LIMIT 0,10")
    List<News> selectNewArticles();
}
