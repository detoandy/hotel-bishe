package cn.sevenzero.hotel.mapper;

import cn.sevenzero.hotel.mapper.provider.AgentDynaSqlProvider;
import cn.sevenzero.hotel.pojo.Agent;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @作者: 26706
 * @创建日期: 2018/9/18 10:54
 * @功能描述:
 */
public interface AgentMapper {
    @Select("SELECT * FROM agent WHERE name=#{username} AND pwd=#{password}")
    Agent selectAgentBynameAndPwd(@Param("username") String name, @Param("password") String pwd);

    @SelectProvider(type = AgentDynaSqlProvider.class,method = "selectWithParam")
    List<Agent> findAgentsByName(String name);

    @Select("SELECT * FROM agent WHERE id=#{id}")
    Agent selectAgentById(Integer id);

    @Update("UPDATE agent \n" +
            "  SET agent.name=#{ag.name},\n" +
            "      pwd=#{ag.pwd},\n" +
            "      sex=#{ag.sex},\n" +
            "      position=#{ag.position},\n" +
            "      tel=#{ag.tel},\n" +
            "      cpname=#{ag.cpname},\n" +
            "      address=#{ag.address}\n" +
            "  WHERE id=#{ag.id};")
    void updateAgent(@Param("ag") Agent agent);

    @Delete("DELETE FROM agent WHERE id=#{id}")
    void deleteAgentById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("INSERT INTO agent(" +
                 "name,pwd,sex," +
                 "position,tel," +
                 "cpname,address" +
                ") " +
             "VALUES(#{ag.name},#{ag.pwd},#{ag.sex}," +
                 "#{ag.position},#{ag.tel}," +
                 "#{ag.cpname},#{ag.address}" +
            ")")
    void insertAgent(@Param("ag") Agent agent);
}