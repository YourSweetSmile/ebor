package com.example.ebor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/** HelloController */
@RestController
@RequestMapping("/api/hello")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    /**
     * sayHello
     * @return
     */
    @RequestMapping("/say")
    public Map sayHello(){

        logger.info("------sayHello--------");
        Map<String,Object> msg = new HashMap<>();
        msg.put("name", new String("ebor"));
        msg.put("word","hello word!");
        return msg;
    }

}
