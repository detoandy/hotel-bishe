package cn.sevenzero.hotel.mapper;

import cn.sevenzero.hotel.mapper.provider.JiuDianDynaSqlProvider;
import cn.sevenzero.hotel.utils.HotelAndGuestRoom;
import cn.sevenzero.hotel.pojo.JiuDian;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @作者: 姜帆
 * @创建日期: 2018/9/3 11:55
 * @功能描述: 酒店表mapper
 */
public interface JiuDianMapper {
    /**
     * 查询酒店最新的 n 条记录
     * @return 返回酒店列表
     */
    @Select("SELECT jd.id," +
            "jd.name,jd.dizhi," +
            "jd.style,jd.info," +
            "jd.pic,jd.tel " +
            "FROM jiudian jd LIMIT 0,10")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "dizhi", property = "dizhi"),
            @Result(column = "style", property = "style"),
            @Result(column = "info", property = "info"),
            @Result(column = "pic", property = "pic"),
            @Result(column = "tel", property = "tel"),
            @Result(column = "id", property = "guestroomList",
                    many = @Many(
                            select = "cn.sevenzero.hotel.mapper.KeFangMapper.selectGuestRoomsByHId",
                            fetchType = FetchType.LAZY
                    )
            ),
    })
    List<JiuDian> selectNewHotels();

    /**
     * 条件查询
     *
     * @param hotelAndGuestRoom 用户条件
     * @param pageNumber        第几页
     * @return 返回酒店列表
     */
    @SelectProvider(type = JiuDianDynaSqlProvider.class, method = "selectWithParam")
    List<JiuDian> selectHotelsByPojo(@Param("hotelAndGuestRoom") HotelAndGuestRoom hotelAndGuestRoom, @Param("pageNumber") final int pageNumber);

    /**
     * 根据指定id查询酒店
     * @param id
     * @return
     */
    @Select("SELECT jd.id,jd.name," +
               "jd.dizhi,jd.style," +
               "jd.info,jd.pic," +
               "jd.tel " +
            "FROM jiudian jd " +
            "WHERE jd.id=#{id}"
    )
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "dizhi", property = "dizhi"),
            @Result(column = "style", property = "style"),
            @Result(column = "info", property = "info"),
            @Result(column = "pic", property = "pic"),
            @Result(column = "tel", property = "tel"),
            @Result(column = "id", property = "evaluateList",
                    many = @Many(
                            select = "cn.sevenzero.hotel.mapper.PingJiaMapper.selectEvaluateByHId",
                            fetchType = FetchType.LAZY
                    )
            ),
            @Result(column = "id", property = "guestroomList",
                    many = @Many(
                            select = "cn.sevenzero.hotel.mapper.KeFangMapper.selectGuestRoomsByHId",
                            fetchType = FetchType.LAZY
                    )
            ),
    })
    JiuDian selectHotelById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("INSERT INTO jiudian(name,dizhi,style,info,pic,tel) " +
            "VALUES(#{hotel.name},#{hotel.dizhi},#{hotel.style},#{hotel.info},#{hotel.pic},#{hotel.tel})")
    void insertHotel(@Param("hotel") JiuDian jiuDian);

    /**
     * 删除酒店
     * @param id
     */
    @Delete("DELETE FROM jiudian WHERE id=#{id}")
    void deleteHotel(Integer id);

    /**
     * 修改酒店
     * @param jiuDian
     */
    @Update("UPDATE jiudian " +
            "SET name=#{hotel.name},dizhi=#{hotel.dizhi}," +
                "style=#{hotel.style},info=#{hotel.info}," +
                "pic=#{hotel.pic},tel=#{hotel.tel} " +
            "WHERE id=#{hotel.id}")
    void updateHotel(@Param("hotel") JiuDian jiuDian);

    /**
     *
     * @param hotelName
     * @return
     */
    @SelectProvider(type =JiuDianDynaSqlProvider.class,method = "selectByName")
    List<JiuDian> selectHotelByName(String hotelName);
}
