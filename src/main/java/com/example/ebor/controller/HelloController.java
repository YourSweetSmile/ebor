package com.example.ebor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/** HelloController */
@RestController
@Slf4j
@RequestMapping("/api/hello")
public class HelloController {

    /**
     * sayHello
     * @return
     */
    @RequestMapping("/say")
    public Map sayHello(){

        log.info("------sayHello--------");
        Map<String,Object> msg = new HashMap<>();
        msg.put("name", new String("ebor"));
        msg.put("word","hello word!");
        return msg;
    }

}
