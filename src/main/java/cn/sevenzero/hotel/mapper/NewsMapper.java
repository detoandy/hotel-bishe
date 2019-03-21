package cn.sevenzero.hotel.mapper;

import cn.sevenzero.hotel.pojo.News;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
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
