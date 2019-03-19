package cn.sevenzero.hotel.web.controller;

import cn.sevenzero.hotel.constant.HotelConstant;
import cn.sevenzero.hotel.pojo.UserInfo;
import cn.sevenzero.hotel.service.OrderService;
import cn.sevenzero.hotel.utils.HotelResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

/**
 * @作者: 姜帆
 * @创建日期: 2018/9/13 12:53
 * @功能描述: 用户查看自己的个人资料以及编辑
 * 用户查看自己的订单
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(HotelController.class);

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "info")
    public String goUserInfoPage() {
        return "userinfo";
    }

    /**
     * 根据用户手机号查询用户订单
     *
     * @param userPhone
     * @return
     */
    @GetMapping("order/{userPhone}")
    public String showOrders(@PathVariable String userPhone, HttpSession session, Model model) {
        boolean result=checkLegality(session,userPhone);
        if(!result){// 判断是否为窃取数据的用户
            session.setAttribute("user",null);// 注销当前用户
            return HotelConstant.REDIRECT+"/hotel/list";
        }
        HotelResult hotelResult= orderService.findOrdersByUserPhone(userPhone);
        model.addAttribute("result",hotelResult);
        return "userOrder";
    }

    /**
     * 校验查询的订单 是不是登陆人的订单 如果不是登陆人的订单就不让查询
     * @param session
     * @param userPhone
     */
    private boolean checkLegality(HttpSession session,String userPhone){
        UserInfo user= (UserInfo) session.getAttribute("user");
        String tel= user.getTel();
        if (!tel.equals(userPhone)){
           // 恶意查询 直接注销掉当前用户的登陆
           return false;
        }
        return true;
    }
}