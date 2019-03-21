package cn.sevenzero.hotel.web.controller;

import cn.sevenzero.hotel.pojo.YuDing;
import org.springframework.stereotype.Controller;

/**
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
