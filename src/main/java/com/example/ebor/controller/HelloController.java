package com.example.ebor.controller;

import com.example.ebor.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping("/test")
    public Map test(){

        Map<String,Object> msg = new HashMap<>();
        msg.put("name", new String("jack"));
        throw new BusinessException(2,"fsdjlkfsdaf");
        //return msg;
    }
}
