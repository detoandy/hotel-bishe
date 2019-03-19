package cn.sevenzero.hotel.config;

import cn.sevenzero.hotel.web.Interceptor.AdminInterceptor;
import cn.sevenzero.hotel.web.Interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootConfiguration
public class MainConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private UserInterceptor userInterceptor;

    @Autowired
    private AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(userInterceptor).
                addPathPatterns("/user/*").
                addPathPatterns("/user/*/*");

        /**
         * 拦截 admin下面所有的请求
          */
        registry.addInterceptor(adminInterceptor).
                addPathPatterns("/admin/*").
                addPathPatterns("/admin/*/*").
                addPathPatterns("/admin/*/*/*").
                addPathPatterns("/admin/*/*/*/*");
    }
}
