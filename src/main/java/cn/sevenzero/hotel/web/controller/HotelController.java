package cn.sevenzero.hotel.web.controller;

import cn.sevenzero.hotel.service.KeFangService;
import cn.sevenzero.hotel.service.PingJiaService;
import cn.sevenzero.hotel.utils.HotelAndGuestRoom;
import cn.sevenzero.hotel.service.JiuDianService;
import cn.sevenzero.hotel.utils.HotelResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 */
@Controller
@RequestMapping("hotel")
public class HotelController {

    private static final Logger logger = LoggerFactory.getLogger(HotelController.class);

    @Autowired
    private JiuDianService jiuDianService;

    @Autowired
    private PingJiaService pingJiaService;

    @Autowired
    private KeFangService keFangService;

    @GetMapping(value ="list")
    public String showHotelList(Model model){
        // 查询酒店列表
        HotelResult result= jiuDianService.findNewHotels();
        model.addAttribute("result",result);
        return "jiudian";
    }

    @GetMapping(value= "query")
    public String queryHotels(HotelAndGuestRoom hotelAndGuestRoom,Model model){
        HotelResult result= jiuDianService.findHotelsByPojo(hotelAndGuestRoom);
        logger.info(result.toString());
        model.addAttribute("result",result);
        return "jiudian";
    }

    /**
     * 根据酒店id 查询酒店详情
     * @param hotelId
     * 一对多映射
     */
    @GetMapping(value = "details/{hotelId}")
    public String queryDetails(@PathVariable  Integer hotelId,Model model){
         HotelResult  result= jiuDianService.findHotelById(hotelId);// 查询酒店详情
         logger.info(result.toString());
         model.addAttribute("result",result);
         return "jiu_detail";
    }

    /**
     * 根据酒店房间id查询房间
     * @param guestRoomId
     * @return
     */
    @GetMapping(value = "reservations/{guestRoomId}")
    public String reservations(@PathVariable Integer guestRoomId,Model model){
        HotelResult result= keFangService.selectGuestRoomsById(guestRoomId);//查询房间
        model.addAttribute("result",result);
        return "yuding";
    }
}