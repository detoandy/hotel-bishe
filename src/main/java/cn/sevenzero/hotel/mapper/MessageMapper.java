package cn.sevenzero.hotel.mapper;

import cn.sevenzero.hotel.pojo.Message;
import cn.sevenzero.hotel.pojo.News;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @作者: 26706
 * @创建日期: 2018/9/3 16:55
 * @功能描述:
 */
public interface MessageMapper {
    /**
     * 查询最新的10 条留言
     * @return
     */
    @Select("SELECT " +
                     "mess.id,mess.msg," +
                     "mess.appuser,mess.date," +
                     "mess.reply " +
            "FROM message mess")
    List<Message> selectNewMessages();
}
