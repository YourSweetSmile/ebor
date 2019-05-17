package com.example.ebor.controller;

import com.example.ebor.model.TestSysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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
    public Map sayHello(TestSysUser user){

        logger.info("------sayHello--------");
        Map<String,Object> msg = new HashMap<>();
        msg.put("name", new String("ebor"));
        msg.put("word","hello word!");
        return msg;
    }

    /**
     * post 请求体传入json测试
     * @param user
     * @return
     */
    @RequestMapping("user/get")
    public Map getWord(@RequestBody TestSysUser user){

        Map<String,Object> msg = new HashMap<>();
        msg.put("user", user);
        msg.put("word", "hello word");

        return msg;
    }

}
