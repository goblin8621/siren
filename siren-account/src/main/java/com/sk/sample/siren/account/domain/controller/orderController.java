package com.sk.sample.siren.account.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
public class orderController {
    
    @GetMapping("/orderStart")
    public String orderStart(){
        return "aaaaaaa";
    }
}
