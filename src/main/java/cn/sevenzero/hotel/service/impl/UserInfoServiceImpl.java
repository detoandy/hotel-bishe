package cn.sevenzero.hotel.service.impl;

import cn.sevenzero.hotel.mapper.UserInfoMapper;
import cn.sevenzero.hotel.pojo.UserInfo;
import cn.sevenzero.hotel.service.UserInfoService;
import cn.sevenzero.hotel.utils.Common;
import cn.sevenzero.hotel.utils.HotelResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @作者: 姜帆
 * @创建日期: 2018/9/13 14:23
 * @功能描述:
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo userLogin(UserInfo userInfo) {
        UserInfo user=userInfoMapper.selectUserInfoBySelf(userInfo);
        return user;
    }

    @Override
    public void userRegister(UserInfo userInfo) {
        userInfoMapper.insertUserInfo(userInfo);
    }
}