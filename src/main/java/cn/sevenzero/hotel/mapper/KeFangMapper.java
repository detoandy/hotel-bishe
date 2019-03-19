package cn.sevenzero.hotel.mapper;

import cn.sevenzero.hotel.mapper.provider.KeFangDynaSqlProvider;
import cn.sevenzero.hotel.pojo.KeFang;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @作者: 姜帆
 * @创建日期: 2018/9/7 15:06
 * @功能描述:
 */
public interface KeFangMapper {
    /**
     * 根据酒店id查询房间列表
     *
     * @param hotelId 酒店id
     * @return
     */
    @Select("SELECT * FROM kefang kf WHERE jid=#{hotelId}")
    @Results({ //配置一对多 关联映射
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "chuang", property = "chuang"),
            @Result(column = "ren", property = "ren"),
            @Result(column = "price", property = "price"),
            @Result(column = "type", property = "type"),
            @Result(column = "state", property = "state"),
    })
    List<KeFang> selectGuestRoomsByHId(Integer hotelId);


    @Select("SELECT * FROM kefang kf WHERE kf.id=#{id}")
    KeFang selectGuestRoomsById(Integer id);


    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("INSERT INTO kefang(jid,name,chuang,ren,price,type) " +
            "VALUES(" +
                     "#{hotelId},#{room.name}," +
                     "#{room.chuang},#{room.ren}," +
                     "#{room.price}," +
                     "#{room.type}" +
            ")")
    void insertGuestRoom(@Param("room") KeFang keFang,@Param("hotelId") Integer hotelId);

    @Update("UPDATE kefang " +
            "SET name=#{guestroom.name},chuang=#{guestroom.chuang}," +
                 "ren=#{guestroom.ren},price=#{guestroom.price}," +
                 "type=#{guestroom.type},state=#{guestroom.state}" +
            " WHERE id=#{guestroom.id}")
    void updateGuestRoom(@Param("guestroom") KeFang keFang);

    @Delete("DELETE FROM kefang WHERE id=#{id}")
    void deleteGuestRoom(Integer id);

    @SelectProvider(type = KeFangDynaSqlProvider.class,method = "selectByName")
    List<KeFang> selectGuestRoomByRoomName(String roomName);
}