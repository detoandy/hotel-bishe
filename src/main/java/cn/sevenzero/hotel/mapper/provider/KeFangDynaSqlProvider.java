package cn.sevenzero.hotel.mapper.provider;

import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @作者: 姜帆
 * @创建日期: 2018/9/26 15:29
 * @功能描述:
 */
public class KeFangDynaSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(KeFangDynaSqlProvider.class);

    public String selectByName(String hotelName) {
        String sql = new SQL() {{
            SELECT("*");// 记得改成投影方式
            FROM("kefang");
            if (hotelName == null) {
                WHERE("name LIKE '%%'");
            } else {
                WHERE("name LIKE CONCAT('%',#{hotelName},'%')");
                logger.info("other sql ???");
            }
        }}.toString();
        logger.info(sql);
        return sql;
    }
}
