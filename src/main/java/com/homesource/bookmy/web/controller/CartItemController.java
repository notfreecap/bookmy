package com.homesource.bookmy.web.controller;

import com.homesource.bookmy.domain.dto.CartItemDto;
import com.homesource.bookmy.domain.service.CartItemService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/cartitem")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    public ResponseEntity<CartItemDto> createCartItem(@RequestBody CartItemDto cartItemDto){
        log.info("Creating CartItem {}", cartItemDto);
        return new ResponseEntity<>(cartItemService.createCartItem(cartItemDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartItemDto> updateCartItem(@PathVariable Long id, @RequestBody CartItemDto cartItemDto){
        if (id == null || cartItemDto == null) {
            log.error("Unable to update CartItem with id {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        cartItemDto.setItemId(id);
        return new ResponseEntity<>(cartItemService.updateCartItem(cartItemDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeCartItem(@PathVariable Long id){
        if (!cartItemService.deleteCartItem(id)) {
            log.error("Unable to delete CartItem with id {}", id);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(204).build();
    }
}
