package cn.sevenzero.hotel.mapper;

import cn.sevenzero.hotel.pojo.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @作者: 26706
 * @创建日期: 2018/9/13 14:15
 * @功能描述:
 */
public interface UserInfoMapper {
    @Select("SELECT " +
                 "uinfo.id,uinfo.name," +
                 "uinfo.pwd,uinfo.sex," +
                 "uinfo.age,uinfo.tel," +
                 "uinfo.address,uinfo.email " +
            "FROM userinfo uinfo " +
            "WHERE name=#{userInfo.name} " +
            "AND pwd=#{userInfo.pwd}")
    UserInfo selectUserInfoBySelf(@Param("userInfo") UserInfo userInfo);


    @Options(useGeneratedKeys = true,keyProperty = "id") // 使用主键
    @Insert("INSERT INTO " +
               "userinfo(name,pwd,sex,age,tel,address,email) " +
            "VALUES(#{userInfo.name},#{userInfo.pwd}," +
                    "#{userInfo.sex},#{userInfo.age}," +
                    "#{userInfo.tel},#{userInfo.address}," +
                    "#{userInfo.email})")
    void insertUserInfo(@Param("userInfo") UserInfo userInfo);
}