package cn.sevenzero.hotel.mapper.provider;

import cn.sevenzero.hotel.utils.HotelAndGuestRoom;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
public class AgentDynaSqlProvider {
    private final Logger logger= LoggerFactory.getLogger(AgentDynaSqlProvider.class);

    public String selectWithParam(final String name){
       String sql=new SQL(){{
           SELECT("id,name,pwd,tel,state,rid,create_time createTime,update_time updateTime");
           FROM("agent");
           if (name==null){
               WHERE("name LIKE '%%'");
           }else {
               WHERE("name LIKE CONCAT('%',#{name},'%')");
           }
       }}.toString();
       logger.info(sql);
       return sql;
    }
}