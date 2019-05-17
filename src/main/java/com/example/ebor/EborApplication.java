package com.example.ebor;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.ebor.mapper")
public class EborApplication {

	private static final Logger logger = LoggerFactory.getLogger(EborApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(EborApplication.class, args);
		logger.info("EborApplication启动！");
	}

}

