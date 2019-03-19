package cn.sevenzero.hotel.web.Interceptor;

import cn.sevenzero.hotel.pojo.Agent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @作者: 26706
 * @创建日期: 2018/9/19 10:38
 * @功能描述:
 */
@Component
public class AdminInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("request:"+request.getRequestURI());
        HttpSession session= request.getSession();
        Agent agent= (Agent) session.getAttribute("admin");
        if (agent==null){
            response.sendRedirect("/go_admin_login_page");
            return false;
        }
        return true;
    }
}