package com.xdl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
@MapperScan(basePackages="com.xdl.Mapper")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
