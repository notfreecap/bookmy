package com.homesource.bookmy.persistence.repository;

import com.homesource.bookmy.domain.dto.BookDto;
import com.homesource.bookmy.domain.dto.CartItemDto;
import com.homesource.bookmy.persistence.mapper.CartItemMapper;
import com.homesource.bookmy.persistence.mapper.CartMapper;
import com.homesource.bookmy.persistence.repository.jpa.ProductoFacturaJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductoFacturaRepositoryTest {

    @Autowired
    ProductoFacturaJpaRepository productoFacturaJpaRepository;

    CartItemMapper cartItemMapper;

    ProductoFacturaRepository productoFacturaRepository;

    CartItemDto cartItem;

    @BeforeEach
    void setUp() {
        productoFacturaRepository = new ProductoFacturaRepository(productoFacturaJpaRepository, cartItemMapper);

        cartItem = CartItemDto.builder()
                .type("SALE")
                .book(BookDto.builder().bookId((long)1).build())
                .build();
    }

    @Test
    void createCartItem() {

        /*CartItemDto result = productoFacturaRepository.createCartItem(cartItem);
        assertEquals(cartItem.getType(), result.getType());*/

    }

    @Test
    void updateCartItem() {
    }

    @Test
    void deleteCartItem() {
    }
}