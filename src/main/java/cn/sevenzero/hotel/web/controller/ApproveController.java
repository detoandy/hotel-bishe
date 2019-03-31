package cn.sevenzero.hotel.web.controller;

import cn.sevenzero.hotel.pojo.Room;
import cn.sevenzero.hotel.service.ApproveService;
import cn.sevenzero.hotel.service.RoomService;
import cn.sevenzero.hotel.utils.HotelResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 */
@Controller
@RequestMapping(value = "approve")
public class ApproveController {

    @Autowired
    private ApproveService approveService;


    /**
     * 显示预定列表
     * @return
     */
    @GetMapping(value = "/list")
    public String getRoomList(@Param("name") String name, Model model){
        HotelResult result= approveService.getApproveList();
        model.addAttribute("result",result);
        return "X-admin/approve-list";
    }

}
