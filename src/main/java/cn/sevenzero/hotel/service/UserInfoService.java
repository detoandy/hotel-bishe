package cn.sevenzero.hotel.service;

import cn.sevenzero.hotel.pojo.UserInfo;
import cn.sevenzero.hotel.utils.HotelResult;

/**
 * @作者: 26706
 * @创建日期: 2018/9/13 14:22
 * @功能描述:
 */
public interface UserInfoService {
    UserInfo userLogin(UserInfo userInfo);
    void userRegister(UserInfo userInfo) throws Exception;
}
