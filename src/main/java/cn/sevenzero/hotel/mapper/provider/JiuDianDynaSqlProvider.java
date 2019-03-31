package cn.sevenzero.hotel.mapper.provider;

import cn.sevenzero.hotel.utils.HotelAndGuestRoom;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @功能描述: 酒店动态条件
 */
public class JiuDianDynaSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(JiuDianDynaSqlProvider.class);

    /**
     * 根据用户条件进行查询酒店列表
     *
     * @param hotelAndGuestRoom 用户查询条件
     */

    public String selectWithParam(@Param("hotelAndGuestRoom") final HotelAndGuestRoom hotelAndGuestRoom, @Param("pageNumber") final int pageNumber) {
        String sql = new SQL() {
            {
                SELECT_DISTINCT("jd.*");
                FROM("jiudian jd,kefang ke");
                WHERE("ke.jid=jd.id");
                if (!"".equals(hotelAndGuestRoom.getDizhi())) { //地址
                    AND();
                    WHERE("jd.dizhi LIKE CONCAT('%',#{hotelAndGuestRoom.dizhi},'%')");
                }
                if (!"".equals(hotelAndGuestRoom.getName())) {// 酒店名
                    AND();
                    WHERE("jd.name LIKE CONCAT('%',#{hotelAndGuestRoom.name},'%')");
                }
                // 房价
                if (hotelAndGuestRoom.roomPriceMark0) { //房价不限的情况
                    AND();
                    WHERE("ke.price LIKE '%%'");
                } else if (hotelAndGuestRoom.roomPriceMark1) {  //价格+
                    AND();
                    WHERE("ke.price>#{hotelAndGuestRoom.roomPrice}");
                } else if (hotelAndGuestRoom.roomPriceMark2) {  // 区间价格
                    AND();
                    WHERE("ke.price BETWEEN #{hotelAndGuestRoom.between} AND #{hotelAndGuestRoom.and}");
                } else {//指定价格
                    AND();
                    WHERE("ke.price<#{hotelAndGuestRoom.price}");
                }
                // 人数
                if (hotelAndGuestRoom.numberOfPeopleMark0) { // 人数不限的条件
                    AND();
                    WHERE("ke.ren LIKE '%%'");
                } else if (hotelAndGuestRoom.numberOfPeopleMark1) { // 带+ >
                    AND();
                    WHERE("ke.ren>#{hotelAndGuestRoom.numberOfpeople}");
                } else {// 直接数字
                    AND();
                    WHERE("ke.ren=#{hotelAndGuestRoom.ren}");
                }
                // 星级
                String style = hotelAndGuestRoom.getStyle();
                if (!"".equals(style)) {
                    if (style.equals("arbitrarily")) { // 任意
                        AND();
                        WHERE("jd.style LIKE '%%'");
                    } else {
                        AND();
                        WHERE("jd.style=#{hotelAndGuestRoom.style}");
                    }
                }
            }
        }.toString();
        sql += " LIMIT #{pageNumber},10";//分页
        logger.info("\r\n" + sql);
        return sql;
    }

    /**
     * @param hotelName
     * @return
     */
    public String selectByName(String hotelName) {
        String sql = new SQL() {{
            SELECT("*");// 记得改成投影方式
            FROM("jiudian");
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