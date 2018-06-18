package com.alex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,io.shardingsphere.jdbc.spring.boot.SpringBootConfiguration.class})
@ImportResource({"classpath*:applicationContext-*.xml"})
@MapperScan("com.alex.dao.mapper")
public class DbrwApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbrwApplication.class, args);
	}
}
