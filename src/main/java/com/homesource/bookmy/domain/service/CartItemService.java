package com.homesource.bookmy.domain.service;

import com.homesource.bookmy.domain.dto.CartItemDto;
import com.homesource.bookmy.domain.repository.CartItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public CartItemDto createCartItem(CartItemDto cartItemDto){
        return cartItemRepository.createCartItem(cartItemDto);
    }

    public CartItemDto updateCartItem(CartItemDto cartItemDto){
        return cartItemRepository.updateCartItem(cartItemDto);
    }

    public boolean deleteCartItem(Long id){
        return cartItemRepository.deleteCartItem(id);
    }

}
