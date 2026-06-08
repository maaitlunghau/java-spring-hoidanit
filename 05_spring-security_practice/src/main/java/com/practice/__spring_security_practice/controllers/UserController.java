package com.practice.__spring_security_practice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/users")
    public String index() {
        return "user/index";
    }

    @GetMapping("/users/create")
    public String create() {
        return "user/create";
    }

    @GetMapping("/users/update")
    public String update() {
        return "user/update";
    }
}
