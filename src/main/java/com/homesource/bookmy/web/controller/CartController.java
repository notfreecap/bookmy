package com.homesource.bookmy.web.controller;

import com.homesource.bookmy.domain.dto.CartDto;
import com.homesource.bookmy.domain.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping
    public ResponseEntity<List<CartDto>> getAll(){
        log.info("Getting all carts");
        return new ResponseEntity<>(cartService.findAll(), HttpStatus.OK);
    }

}
