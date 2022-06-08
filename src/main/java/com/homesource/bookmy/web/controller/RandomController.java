package com.homesource.bookmy.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/random")
public class RandomController {


    @GetMapping
    public String welcomeRandom(){
        return "test";
    }

}
