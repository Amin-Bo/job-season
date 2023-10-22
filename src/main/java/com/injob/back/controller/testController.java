package com.injob.back.controller;

import com.injob.back.roles.hasAdminRole;
import com.injob.back.roles.hasUserRole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {

    @GetMapping("/admin")
    @hasAdminRole
    public String helloAdmin(){return "hello admin";}

    @GetMapping("/user")
    @hasUserRole
    public String helloUser(){return "hello user";}
}
