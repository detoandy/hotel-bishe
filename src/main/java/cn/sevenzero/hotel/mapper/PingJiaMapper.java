package cn.sevenzero.hotel.mapper;

import cn.sevenzero.hotel.pojo.PingJia;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 */
public interface PingJiaMapper {
    /**
     * 根据酒店id查询评论
      * @param hotelId
     * @return
     */
  @Select("SELECT pj.id,pj.msg," +
             "pj.name,pj.adddate," +
             "pj.jid " +
          "FROM pingjia pj " +
          "WHERE jid=#{hotelId}")
  List<PingJia> selectEvaluateByHId(Integer hotelId);
}