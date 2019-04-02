package cn.sevenzero.hotel.mapper;

import cn.sevenzero.hotel.mapper.provider.RoomDynaSqlProvider;
import cn.sevenzero.hotel.pojo.KeFang;
import cn.sevenzero.hotel.pojo.Room;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 */
public interface RoomMapper {

    /**
     * 根据酒店id查询房间列表
     * @return
     */
    @Select("SELECT * FROM room")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "count", property = "count"),
            @Result(column = "person", property = "person"),
            @Result(column = "price", property = "price"),
            @Result(column = "comment", property = "comment"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
    })
    List<Room> getRoomList();

    @Select("SELECT * FROM room r WHERE r.id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "count", property = "count"),
            @Result(column = "person", property = "person"),
            @Result(column = "price", property = "price"),
            @Result(column = "comment", property = "comment"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
    })
    Room getRoomById(Integer id);

    @Update("UPDATE room \n" +
            "  SET name=#{r.name},count=#{r.count},person=#{r.person},price=#{r.price},comment=#{r.comment}\n" +
            "  WHERE id=#{r.id};")
    void updateRoom(@Param("r") Room room);

    @Delete("DELETE FROM room WHERE id=#{id}")
    void deleteRoomById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("INSERT INTO room(name,count,price,person,comment)" +
            "VALUES(#{r.name},#{r.count},#{r.price},#{r.person},#{r.comment})")
    void saveRoom(@Param("r") Room room);

    @SelectProvider(type = RoomDynaSqlProvider.class,method = "selectByName")
    List<Room> findRoomListByName(String name);


    @SelectProvider(type = RoomDynaSqlProvider.class,method = "selectByName")
    List<KeFang> selectGuestRoomByRoomName(String roomName);

    @Select("SELECT count(1) FROM room room")
    Integer getCount();
}