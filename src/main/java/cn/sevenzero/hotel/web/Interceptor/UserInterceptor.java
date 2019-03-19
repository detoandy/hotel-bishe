package cn.sevenzero.hotel.web.Interceptor;

import cn.sevenzero.hotel.pojo.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class UserInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(UserInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("request:"+request.getRequestURI());
        UserInfo user= (UserInfo) request.getSession().getAttribute("user");
        if(user!=null) return true;
        else{
            response.sendRedirect("/hotel/list");
            return false;
        }
    }
}
