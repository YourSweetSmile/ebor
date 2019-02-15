package com.example.ebor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EborApplication {

	public static void main(String[] args) {

		SpringApplication.run(EborApplication.class, args);
		log.info("EborApplication启动！");
	}

}

