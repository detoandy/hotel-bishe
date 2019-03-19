war包方式部署springboot项目
  第一步修改pom文件
        默认是 <packaging>jar</packaging>
    	修改为 <packaging>war</packaging>

 加入这个依赖是不适用内置的tomcat
 <dependency>
 			<groupId>org.springframework.boot</groupId>
 			<artifactId>spring-boot-starter-web</artifactId>
 			<!-- 移除嵌入式tomcat插件 -->
 			<exclusions>
 				<exclusion>
 					<groupId>org.springframework.boot</groupId>
 					<artifactId>spring-boot-starter-tomcat</artifactId>
 				</exclusion>
 			</exclusions>
 </dependency>

         加入servlet的依赖
        <!--导入servlet的依赖-->
 		<dependency>
 			<groupId>javax.servlet</groupId>
 			<artifactId>javax.servlet-api</artifactId>
 			<scope>provided</scope>
 		</dependency>

第二步修改springboot启动类
@SpringBootApplication
public class HotelApplication extends SpringBootServletInitializer {

	/*public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}*/

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HotelApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}

}

############################################################2018 年 9 月 4 号 进行的修改############################################################################
adlogout.jsp 被我删除了 换成了 一个控制器方法(两个登出的页面被我删除了)

切记 使用  引入静态文件要使用这种方式:th:src="@{~/images/top.jpg}"

注意mybatis报参数绑定异常的时候一定要加上@Param注解(一般一个dao方法中有多个参数时会出现这种情况)

springboot自带json插件在转换前台嵌套类型实体时会报 com.fasterxml.jackson.databind.exc.InvalidDefinitionException
需要在嵌套的实体上加上@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })注解

#2018 9 17
还是需要做一个防爬虫机制(接口保护)