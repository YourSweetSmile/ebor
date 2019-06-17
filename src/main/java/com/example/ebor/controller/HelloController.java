package com.example.ebor.controller;

import com.example.ebor.model.TestSysUser;
import com.example.ebor.service.TestUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** HelloController */
@RestController
@RequestMapping("/api/hello")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private TestUserService testUserService;

    /**
     * sayHello
     * @return
     */
    @RequestMapping("/say")
    public Map sayHello(TestSysUser user){

        logger.info("------sayHello--------");
        Map<String,Object> msg = new HashMap<>();
        msg.put("name", new String("ebor"));
        msg.put("word",System.currentTimeMillis()/1000L+"hello,word");
        return msg;
    }


    @GetMapping("user/id/{id}")
    public TestSysUser getWord(@PathVariable Integer id){

        return testUserService.getUserById(id);
    }


    @GetMapping("user/one")
    public TestSysUser getOne(){

        List<TestSysUser> list = testUserService.getList();
        return list.size()>0? list.get(0):null;
    }

    @GetMapping("user/list")
    public List<TestSysUser> getList(){

        return testUserService.getList();
    }

}
