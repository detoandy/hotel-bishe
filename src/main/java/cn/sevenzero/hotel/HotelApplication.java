package cn.sevenzero.hotel;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement // open事物
@MapperScan("cn.sevenzero.hotel.mapper") // 指定mapper包
@SpringBootApplication
public class HotelApplication /*extends SpringBootServletInitializer*/{

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}

/*	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HotelApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}*/

}
