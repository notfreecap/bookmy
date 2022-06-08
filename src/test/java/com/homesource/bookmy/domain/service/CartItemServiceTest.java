package com.homesource.bookmy.domain.service;

import com.homesource.bookmy.domain.dto.BookDto;
import com.homesource.bookmy.domain.dto.CartItemDto;
import com.homesource.bookmy.domain.repository.CartItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class CartItemServiceTest {

    @Mock
    private CartItemRepository cartItemRepository;

    @InjectMocks
    private CartItemService cartItemService;

    private CartItemDto cartItemDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
        // TODO: Create and use AutoClose

        cartItemDto = CartItemDto.builder()
                .itemId(1L)
                //.addedAt()
                .type("SALE")
                .book(BookDto.builder()
                        .bookId(1L).build())
                .cartId(1L).build();
    }

    @Test
    void createCartItem() {
        Mockito.when(cartItemRepository.createCartItem(cartItemDto)).thenReturn(cartItemDto);
        CartItemDto result = cartItemService.createCartItem(cartItemDto);
        assertEquals(cartItemDto, result);
    }

    @Test
    void updateCartItem() {
        Mockito.when(cartItemRepository.updateCartItem(cartItemDto)).thenReturn(cartItemDto);
        CartItemDto result = cartItemService.createCartItem(cartItemDto);
        assertEquals(cartItemDto, result);
    }

    @Test
    void deleteCartItem() {
        Mockito.when(cartItemRepository.deleteCartItem(1L)).thenReturn(true);
        boolean result = cartItemService.deleteCartItem(1L);
        assertTrue(result);
    }
}