package com.example.ebor.controller;

import com.example.ebor.model.TestSysUser;
import com.example.ebor.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping("/login")
    public Map<String, String> login(@RequestBody TestSysUser user) {

        return authService.login(user);
    }
}
