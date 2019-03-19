package cn.sevenzero.hotel.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.ResourceServlet;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 德鲁伊 配置
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    // 配置德鲁伊的监控
    // 1 配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean= new ServletRegistrationBean(
                new StatViewServlet(),"/druid/*"
        );
       // new ResourceServlet();
        Map<String,Object>map=new HashMap<>();
        map.put("loginUsername","root");
        map.put("loginPassword","3306");
       // map.put("allow","localhost");
        bean.setInitParameters(map);
        return bean;
    }
    // 2 配置一个监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean=new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String>map=new HashMap<>();
        map.put("exclusions","*.css,*.js,*.jpg,*.png,/druid/*"); // 设置拦截规则
        bean.setInitParameters(map);
        bean.setUrlPatterns(Arrays.asList("/*"));// 设置拦截路径
        return  bean;
    }
}
