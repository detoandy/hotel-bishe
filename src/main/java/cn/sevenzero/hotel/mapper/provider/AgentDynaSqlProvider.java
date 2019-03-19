package cn.sevenzero.hotel.mapper.provider;

import cn.sevenzero.hotel.utils.HotelAndGuestRoom;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @作者: 姜帆
 * @创建日期: 2018/9/11 11:31
 * @功能描述: 酒店动态条件
 */
public class AgentDynaSqlProvider {
    private final Logger logger= LoggerFactory.getLogger(AgentDynaSqlProvider.class);

    public String selectWithParam(final String name){
       String sql=new SQL(){{
           SELECT("*");// 记得改成投影方式
           FROM("agent");
           if (name==null){
               WHERE("name LIKE '%%'");
           }else {
               WHERE("name LIKE CONCAT('%',#{name},'%')");
               logger.info("other sql ???");
           }
       }}.toString();
       logger.info(sql);
       return sql;
    }
}