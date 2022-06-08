package com.homesource.bookmy.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homesource.bookmy.domain.dto.BookDto;
import com.homesource.bookmy.domain.dto.CartItemDto;
import com.homesource.bookmy.domain.service.CartItemService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@WebMvcTest(controllers = CartItemController.class)
class CartItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CartItemService cartItemService;

    /*@InjectMocks*/
    /*@Autowired
    private CartItemController cartItemController;*/


    private CartItemDto cartItemDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        cartItemDto = CartItemDto.builder()
                .type("SALE")
                .book(BookDto.builder().bookId(1L).build())
                .cartId(1L)
                .build();
    }

    @Test
    @Order(1)
    void shouldCreateCartItem() throws Exception{
        Mockito.when(cartItemService.createCartItem(cartItemDto)).thenReturn(cartItemDto);

        //when
        ResultActions resultActions = mockMvc
                .perform(post("/cartitem")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cartItemDto)));

        //then
        resultActions.andExpect(status().isCreated());
    }

    @Test
    @Order(2)
    void shouldUpdateCartItem() throws Exception{
        //given
        cartItemDto.setBook(BookDto.builder().bookId(2L).build());

        //when
        ResultActions resultActions = mockMvc
                .perform(put("/cartitem/"+"2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cartItemDto)));


        resultActions.andExpect(status().isOk());
    }

    @Test
    @Order(3)
    void shouldRemoveCartItem() throws Exception{

        //when
        ResultActions resultActions = mockMvc
                .perform(delete("/cartitem/"+"1"));

        //then
        resultActions.andExpect(status().isNotFound());
    }
}