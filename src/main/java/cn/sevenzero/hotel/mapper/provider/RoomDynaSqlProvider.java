package cn.sevenzero.hotel.mapper.provider;

import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 */
public class RoomDynaSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(RoomDynaSqlProvider.class);

    public String selectByName(final String name) {
        String sql = new SQL() {{
            SELECT("id,name,person,price,create_time createTime,update_time updateTime");
            FROM("room");
            if (!StringUtils.isEmpty(name)) {
                WHERE("name LIKE CONCAT('%',#{name},'%')");
            }
        }}.toString();
        logger.info(sql);
        return sql;
    }
}
