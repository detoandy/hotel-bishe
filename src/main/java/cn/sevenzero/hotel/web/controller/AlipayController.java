package cn.sevenzero.hotel.web.controller;

import cn.sevenzero.hotel.pojo.YuDing;
import org.springframework.stereotype.Controller;

/**
 * @作者: 姜帆
 * @创建日期: 2018/9/4 11:02
 * @功能描述: 支付包支付接口
 */
@Controller
public class AlipayController {

    /**
     *  用户使用支付宝支付的控制器
     * @param yuDing 封装了用户预定表的前台表单参数
     * @return 返回交易成功之后的视图
     */
    public String payHotel(YuDing yuDing){
      return "";
    }
}
