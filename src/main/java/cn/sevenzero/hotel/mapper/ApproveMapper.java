package cn.sevenzero.hotel.mapper;

import cn.sevenzero.hotel.mapper.provider.ApproveDynaSqlProvider;
import cn.sevenzero.hotel.pojo.Approve;
import cn.sevenzero.hotel.pojo.Room;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 */
public interface ApproveMapper {

    /**
     * @return
     */
    @SelectProvider(type = ApproveDynaSqlProvider.class,method = "selectByParams")
    List<Approve> getApproveList();


    @Select("SELECT count(1) FROM approve")
    Integer getCount();
}