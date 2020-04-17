package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@MapperScan("com.gyhl.test.mapper")
@SpringBootApplication
@EnableScheduling
public class SpringBoot01Test2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot01Test2Application.class, args);
	}

}
