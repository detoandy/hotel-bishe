package cn.sevenzero.hotel.mapper.provider;

import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 */
public class ApproveDynaSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(ApproveDynaSqlProvider.class);

    public String selectByParams(final String name) {
        String sql = new SQL() {{
            SELECT("id,name,tel,count,room,bdate,edate, createTime,update_time updateTime");
            FROM("approve");
            if (!StringUtils.isEmpty(name)) {
                WHERE("name LIKE CONCAT('%',#{name},'%')");
            }
        }}.toString();
        logger.info(sql);
        return sql;
    }
}
