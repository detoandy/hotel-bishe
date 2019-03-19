package cn.sevenzero.hotel.service;

import cn.sevenzero.hotel.constant.HotelConstant;
import cn.sevenzero.hotel.pojo.Agent;
import cn.sevenzero.hotel.utils.HotelResult;

import java.sql.SQLException;

/**
 * @作者: 姜帆
 * @创建日期: 2018/9/18 10:56
 * @功能描述:
 */
public interface AgentService {
    /**
     * 代理登陆
     * @param agent
     * @return
     */
    HotelResult agentLogin(Agent agent);

    /**
     *
     * @param name
     * @return
     */
    HotelResult findAgentsByName(String name);

    /**
     * 无条件查询
     * @return
     */
    HotelResult findAgentsByName();

    /**
     *
      * @param id
     * @return
     */
    HotelResult findAgentById(Integer id);

    /**
     *
     * @return
     */
    void editAgent(Agent agent) throws Exception;

    /**
     *
     * @param id
     * @return
     */
    void removeAgentById(Integer id) throws Exception;

    /**
     *
     * @param agent
     * @return
     */
    void createAgent(Agent agent) throws Exception;
}
