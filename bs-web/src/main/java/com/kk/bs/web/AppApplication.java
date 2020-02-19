package com.kk.bs.web;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 *  注：为了避免扫描路径不一致，请将启动类放在Root Package 即 com.hehe.integration
 *  如果出现包找不到的问题，修改MapperScan就可以了
 *  ComponentScan是用来配置自动扫描包路径下的所有@Controller、@Service、@Repository、@Component的类。
 *  MapperScan是用来配置要扫描的Mapper类的包的路径
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@ComponentScan(value = {
		"com.kk.bs.comm.constant",
		"com.kk.bs.*",
})
@MapperScan(basePackages = {
		"com.kk.bs.mapper.*",
})
@EnableCaching
public class AppApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
}
