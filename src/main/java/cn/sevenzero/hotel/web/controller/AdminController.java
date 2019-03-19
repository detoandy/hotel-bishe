package cn.sevenzero.hotel.web.controller;

import cn.sevenzero.hotel.constant.HotelConstant;
import cn.sevenzero.hotel.pojo.Agent;
import cn.sevenzero.hotel.pojo.JiuDian;
import cn.sevenzero.hotel.pojo.KeFang;
import cn.sevenzero.hotel.service.AgentService;
import cn.sevenzero.hotel.service.JiuDianService;
import cn.sevenzero.hotel.service.KeFangService;
import cn.sevenzero.hotel.service.OrderService;
import cn.sevenzero.hotel.utils.HotelResult;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

/**
 * @作者: 姜帆
 * @创建日期: 2018/9/17 20:13
 * @功能描述:
 */
@Controller
public class AdminController {

    private final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AgentService agentService;

    @Autowired
    private JiuDianService jiuDianService;

    @Autowired
    private KeFangService keFangService;

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "admin_login")
    public String adminLogin(Agent agent, HttpSession session) {
        HotelResult result = agentService.agentLogin(agent);
        Agent data = (Agent) result.getData();
        if (data == null) {
            return HotelConstant.REDIRECT + "/hotel/list";
        }
        session.setAttribute("admin", data);
        return HotelConstant.REDIRECT + "/admin/index";
    }

    /**
     * 显示管理员 主页面
     *
     * @return
     */
    @GetMapping(value = "admin/index")
    public String showAdminIndexPage() {
        return "admin/index";
    }

    /**
     * 首页用户列表
     *
     * @return
     */
    @GetMapping(value = "admin/user/list")
    public String showUserList(Model model) {
        HotelResult result = agentService.findAgentsByName();
        model.addAttribute("result", result);
        return "admin/user/list";
    }

    @PostMapping(value = "admin/user/query")
    public String userQuery(String queryName,Model model){
        logger.info("queryName:"+queryName);
        HotelResult result = agentService.findAgentsByName(queryName);
        model.addAttribute("result", result);
        return "admin/user/list";
    }
    /**
     * 查询指定用户具体信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "admin/user/info/{id}")
    public String showUserInfo(@PathVariable Integer id, HttpSession session) {
        HotelResult result = agentService.findAgentById(id);
        session.setAttribute("result", result);
        return "admin/user/update";
    }

    /**
     * 用户指定信息更新
     *
     * @param agent
     * @return
     */
    @PostMapping(value = "admin/user/update")
    public String userUpdate(Agent agent) {
        HotelResult result;
        try {
            agentService.editAgent(agent);
        } catch (Exception e) {
            result = HotelResult.build(500, e.getMessage());//构建错误消息
            logger.error("err msg:" + result.getMsg());
            return "err";
        }
        result = HotelResult.ok();
        return HotelConstant.REDIRECT + "/admin/user/list";
    }

    /**
     * 删除指定用户
     *
     * @param id
     * @return
     */
    @GetMapping(value = "admin/user/delete/{id}")
    public String userDelete(@PathVariable Integer id) {
        HotelResult result;
        try {
            agentService.removeAgentById(id);
        } catch (Exception e) {
            result = HotelResult.build(500, e.getMessage());
            logger.error("err msg:" + result.getMsg());
            return "err";
        }
        result = HotelResult.ok();
        return HotelConstant.REDIRECT + "/admin/user/list";
    }

    /**
     * 添加用户
     *
     * @param agent
     * @return
     */
    @PostMapping(value = "admin/user/create")
    public String createUser(Agent agent) {
        HotelResult result;
        try {
            agentService.createAgent(agent);
        } catch (Exception e) {
            result = HotelResult.build(500, e.getMessage());
            logger.error("err msg:" + result.getMsg());
            return "err";
        }
        result = HotelResult.ok();
        return HotelConstant.REDIRECT + "/admin/user/list";
    }

    @GetMapping(value = "admin_exit")
    @ResponseBody
    public HotelResult userLoginOut(HttpSession session) throws IOException {
        try {
            session.removeAttribute("admin");//从会话中移除用户
            return HotelResult.ok("用户退出");
        } catch (Exception e) {
            return HotelResult.build(500, e.getMessage());
        }
    }

    @GetMapping(value = "admin/user/add")
    public String goAddPage() {
        return "admin/user/add";
    }

    @GetMapping(value = "admin/top")
    public String top() {
        return "admin/admin_top";
    }

    @GetMapping(value = "admin/left")
    public String left() {
        return "admin/left";
    }

    @GetMapping(value = "go_admin_login_page")
    public String goLoginPage() {
        return "admin/login";
    }

    /**
     * 酒店列表展示
     * @param model
     * @return
     */
    @GetMapping(value = "admin/hotel/list")
    public String showHoltelList(Model model){
        HotelResult result= jiuDianService.findNewHotels();
        logger.info(result.toString());
        model.addAttribute("result",result);
        return "admin/hotel/list";
    }

    /**
     * 跳转酒店添加页面
     */
    @GetMapping(value = "admin/hotel/add")
    public String goHotelAddPage(){
        return "admin/hotel/add";
    }

    @PostMapping(value = "admin/hotel/create")
    public String createHotel(@Valid @ModelAttribute("jiuDian") JiuDian jiuDian, BindingResult result,Model model){
        // 表单数据 不合法
        if(result.hasErrors()){ //暂时这样处理
            return "err";
        }
        try {
            jiuDianService.createHotel(jiuDian);
        } catch (Exception e) {
            // 暂不处理
        }
        return "admin/hotel/add";// 返回添加页码
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "admin/hotel/delete/{id}")
    public String deleteHotel(@PathVariable Integer id){
        try {
            jiuDianService.removeHotel(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HotelConstant.REDIRECT+"/admin/hotel/list";
    }

    /**
     * @param id
     * @return
     */
    @GetMapping(value = "admin/hotel/edit/{id}")
    public String editHotel(@PathVariable Integer id,Model model){
        HotelResult result= jiuDianService.findHotelById(id);
        model.addAttribute("result",result);
        return "/admin/hotel/update";
    }


    /**
     * 修改指定酒店信息
     * @param jiuDian
     * @return
     */
    @PostMapping(value = "admin/hotel/update")
    public String hotelUpdate(JiuDian jiuDian){
        try {
            jiuDianService.editHotel(jiuDian);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HotelConstant.REDIRECT+"/admin/hotel/list";
    }

    /**
     * 查询酒店
     * @param hotelName
     * @return
     */
    @PostMapping(value = "admin/hotel/query")
    public String hotelQuery(String hotelName,Model model){
        HotelResult result=jiuDianService.findHotelByName(hotelName);
        model.addAttribute("result",result);
        return "admin/hotel/list";
    }

    /**
     * 显示酒店客房列表
     * @return
     */
    @GetMapping(value = "admin/hotel/room/{hotelId}")
    public String showGuestRoomList(@PathVariable Integer hotelId,Model model){
        HotelResult result=jiuDianService.findHotelById(hotelId);
        logger.info(result.toString());
        model.addAttribute("result",result);
        return "admin/hotel/room/list";
    }

    /**
     * 跳转到添加客房的页面
     * @return
     */
    @GetMapping(value = "admin/hotel/room/add/{hotelId}")
    public String goAddGuestRoomPage(@PathVariable Integer hotelId,Model model){
        model.addAttribute("hotelId",hotelId);
        return "admin/hotel/room/add";
    }

    /**
     * 添加客房
     * @param keFang
     * @return
     */
    @PostMapping(value = "admin/hotel/room/create")
    public String createGuestRoom(KeFang keFang,Integer hotelId){
        try {
            keFangService.createGuestRoom(keFang,hotelId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/hotel/room/add";
    }

    /**
     * 显示指定的客房信息
     * @param guestRoomId
     * @return
     */
    @GetMapping(value = "admin/hotel/room/edit/{guestRoomId}")
    public String showGuestRoom(@PathVariable Integer guestRoomId,Model model){
        HotelResult result=keFangService.selectGuestRoomsById(guestRoomId);
        model.addAttribute("result",result);
        return "admin/hotel/room/update";
    }

    /**
     * 修改酒店信息
     * @param keFang
     * @return
     */
    @PostMapping(value = "admin/hotel/room/update")
    public String updateGuestRoom(KeFang keFang){
        try {
            keFangService.updateGuestRoom(keFang);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HotelConstant.REDIRECT+"/admin/hotel/list";
    }

    @GetMapping(value = "admin/hotel/room/delete/{guestRoomId}")
    public String deleteGuestRoom(@PathVariable Integer guestRoomId){
        try {
            keFangService.removeGuestRoom(guestRoomId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HotelConstant.REDIRECT+"/admin/hotel/list";
    }

    @PostMapping(value = "admin/hotel/room/query")
    public String queryGuestRoom(String roomName,Model model){
        HotelResult result=keFangService.queryGuestRoomByRoomName(roomName);
        model.addAttribute("result",result);
        return "admin/hotel/room/list";
    }

    /**
     * 查询酒店订单列表
     * @return
     */
    @GetMapping(value = "admin/hotel/orders")
    public String showHotelOrders(Model model){
        HotelResult result= orderService.findOrders();
        logger.info("\n\n\n\n\n"+result.getData().toString());
        model.addAttribute("result",result);
        return "admin/hotel/order/list";
    }

    /**
     * 查询指定手机的订单
     * @param userPhone
     * @param model
     * @return
     */
    @PostMapping(value = "admin/hotel/order/query")
    public String queryOrder(String userPhone,Model model){
        HotelResult result= orderService.findOrdersByUserPhone(userPhone);
        model.addAttribute("result",result);
        return "admin/hotel/order/list";
    }
}