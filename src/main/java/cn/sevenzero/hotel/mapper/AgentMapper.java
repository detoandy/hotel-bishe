package cn.sevenzero.hotel.mapper;

import cn.sevenzero.hotel.mapper.provider.AgentDynaSqlProvider;
import cn.sevenzero.hotel.pojo.Agent;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 */
public interface AgentMapper {
    @Select("SELECT * FROM agent WHERE name=#{username} AND pwd=#{password}")
    Agent selectAgentBynameAndPwd(@Param("username") String name, @Param("password") String pwd);

    @SelectProvider(type = AgentDynaSqlProvider.class,method = "selectWithParam")
    List<Agent> findAgentsByName(String name);

    @Select("SELECT * FROM agent WHERE id=#{id}")
    Agent selectAgentById(Integer id);

    @Update("UPDATE agent \n" +
            "  SET agent.name=#{ag.name},pwd=#{ag.pwd},tel=#{ag.tel},email=#{ag.email},pwd=#{ag.pwd}\n" +
            "  WHERE id=#{ag.id};")
    void updateAgent(@Param("ag") Agent agent);

    @Delete("DELETE FROM agent WHERE id=#{id}")
    void deleteAgentById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("INSERT INTO agent(name,pwd,tel,email)" +
             "VALUES(#{ag.name},#{ag.pwd},#{ag.tel},#{ag.email})")
    void insertAgent(@Param("ag") Agent agent);
}