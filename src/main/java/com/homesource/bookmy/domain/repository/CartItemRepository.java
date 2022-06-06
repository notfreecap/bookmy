package com.homesource.bookmy.domain.repository;

import com.homesource.bookmy.domain.dto.CartItemDto;

public interface CartItemRepository {

    CartItemDto createCartItem(CartItemDto cartItemDto);

    CartItemDto updateCartItem(CartItemDto cartItemDto);

    boolean deleteCartItem(Long id);

}
