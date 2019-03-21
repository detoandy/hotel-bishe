package cn.sevenzero.hotel.web.controller;

import cn.sevenzero.hotel.constant.HotelConstant;
import cn.sevenzero.hotel.pojo.JiuDian;
import cn.sevenzero.hotel.pojo.Message;
import cn.sevenzero.hotel.pojo.News;
import cn.sevenzero.hotel.pojo.UserInfo;
import cn.sevenzero.hotel.service.JiuDianService;
import cn.sevenzero.hotel.service.MessageService;
import cn.sevenzero.hotel.service.NewsService;
import cn.sevenzero.hotel.service.UserInfoService;
import cn.sevenzero.hotel.utils.HotelResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */

@Controller
public class WelcomeController {

    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    private JiuDianService jiuDianService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 展示首页最新的酒店列表
     *
     * @return 返回index视图
     * 描述: 定义自定义结果集的原因是 考虑到后期系统前端升级，以及安卓端的开发做系统支持的。
     */
    @GetMapping("index")
    public String showIndexNewHotels(Model model) {
        // 每次刷新都去刷新数据吧
        Map<String, Object> indexData = new HashMap<>();// 主页数据
        List<JiuDian> hotels = (List<JiuDian>) jiuDianService.findNewHotels().getData(); // 酒店列表
        List<News> articles = (List<News>) newsService.selectNewArticles().getData(); // 文章列表
        List<Message> messages = (List<Message>) messageService.selectNewMessages().getData(); // 回复列表
        // put 数据
        indexData.put("hotels", hotels);
        indexData.put("articles", articles);
        indexData.put("messages", messages);
        // model数据
        model.addAttribute("indexData", indexData);
        return "index"; // 返回视图
    }

    /**
     * 设置默认 欢迎主页
     *
     * @return 转发请求
     */
    @GetMapping("/")
    public String index() {
        return "forward:/index";
    }

    /**
     * 用户注销 (我们约定用户登陆的信息存放在springmvc的Model里面) 这里暂时不做单点登陆
     *
     * @return 返回登陆视图
     */
    @GetMapping("logout")
    public String exit(HttpSession session) {
        session.setAttribute("user", null);
        return HotelConstant.REDIRECT + "/hotel/list";
    }

    @PostMapping("login")
    public String userLogin(HttpSession session, UserInfo userInfo) {
        UserInfo user = (UserInfo) userInfoService.userLogin(userInfo);
        if (user != null) {
            session.setAttribute("user", user);
            return HotelConstant.REDIRECT + "/hotel/list";
        }
        return "err";
    }

    /**
     * 返回注册视图
     *
     * @return
     */
    @GetMapping("register")
    public String goRegisterPage() {
        return "register";
    }

    /**
     * 需要做一个防止爬虫机制
     * @param userInfo
     * @return
     */
    @PostMapping("createuser")
    public String createUser(UserInfo userInfo){
        HotelResult result;
        try {
            userInfoService.userRegister(userInfo);// 用户注册
        } catch (Exception e) {
            result =HotelResult.build(500,e.getMessage());
            logger.error(result.getMsg());
            return "err";
        }
        result=HotelResult.ok();
        return HotelConstant.REDIRECT+"/hotel/list";
    }

}
