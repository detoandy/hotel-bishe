package cn.sevenzero.hotel.web.controller;

import cn.sevenzero.hotel.pojo.Room;
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
@RequestMapping(value = "room")
public class RoomController {

    @Autowired
    private RoomService roomService;


    /**
     * 显示房间列表
     * @return
     */
    @GetMapping(value = "/list")
    public String getRoomList(@Param("name") String name, Model model){
        HotelResult result= roomService.getRoomList(name);
        model.addAttribute("result",result);
        return "X-admin/room-list";
    }

    /**
     * @return
     */
    @GetMapping(value = "/add")
    public String addRoom(Model model){
        return "X-admin/room-add";
    }

    /**
     * @return
     */
    @GetMapping(value = "/edit/{id}")
    public String editRoom(@PathVariable Integer id,Model model){
        HotelResult result = roomService.getRoomById(id);
        model.addAttribute("result",result);
        return "X-admin/room-add";
    }

    @PostMapping(value = "/save")
    @ResponseBody
    public HotelResult saveRoom(Room room, Model model){
        HotelResult result;
        try {
            roomService.saveRoom(room);
        } catch (Exception e) {
            result = HotelResult.build(500, e.getMessage());
            e.printStackTrace();
            return result;
        }
        result = HotelResult.ok();
        return result;
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public HotelResult updateRoom(Room room, Model model){
        HotelResult result;
        try {
            roomService.updateRoom(room);
        } catch (Exception e) {
            result = HotelResult.build(500, e.getMessage());
            e.printStackTrace();
            return result;
        }
        result = HotelResult.ok();
        return result;
    }


    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public HotelResult deleteRoom(@PathVariable Integer id, Model model){
        HotelResult result;
        try {
            roomService.deleteRoomById(id);
        } catch (Exception e) {
            result = HotelResult.build(500, e.getMessage());
            e.printStackTrace();
            return result;
        }
        result = HotelResult.ok();
        return result;
    }
}
