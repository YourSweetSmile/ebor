package com.example.ebor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** HelloController */
@RestController
@Slf4j
public class HelloController {

    /**
     * sayHello
     * @return
     */
    @RequestMapping("/hello")
    public String sayHello(){

        log.info("------sayHello--------");
        return "hello,word!";
    }
}
