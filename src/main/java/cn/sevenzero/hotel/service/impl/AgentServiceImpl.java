package cn.sevenzero.hotel.service.impl;

import cn.sevenzero.hotel.mapper.AgentMapper;
import cn.sevenzero.hotel.pojo.Agent;
import cn.sevenzero.hotel.service.AgentService;
import cn.sevenzero.hotel.utils.Common;
import cn.sevenzero.hotel.utils.HotelResult;
import cn.sevenzero.hotel.web.controller.AdminController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * @功能描述:
 */
@Service
@Transactional
public class AgentServiceImpl implements AgentService {

    private final Logger logger= LoggerFactory.getLogger(AgentServiceImpl.class);

    @Autowired
    private AgentMapper agentMapper;

    @Override
    public HotelResult agentLogin(Agent agent) {
        Agent agentUser= agentMapper.selectAgentBynameAndPwd(agent.getName(),agent.getPwd());
        HotelResult result=Common.wrapService(agentUser,null,new HotelResult(),0);
        return result;
    }

    @Override
    public HotelResult findAgentsByName(String name) {
        List<Agent> agents=agentMapper.findAgentsByName(name);
        HotelResult result=Common.wrapService(agents,name,new HotelResult(),1);
        return result;
    }

    @Override
    public HotelResult findAgentsByName() {
        return findAgentsByName(null);
    }

    @Override
    public HotelResult findAgentById(Integer id) {
        Agent agent= agentMapper.selectAgentById(id);
        HotelResult result= Common.wrapService(agent,"数据为空");
        return result;
    }

    @Override
    public void editAgent(Agent agent) {
        agentMapper.updateAgent(agent);
    }

    @Override
    public void removeAgentById(Integer id) {
        agentMapper.deleteAgentById(id);
    }

    @Override
    public void createAgent(Agent agent) {
        agentMapper.insertAgent(agent);
    }
}
