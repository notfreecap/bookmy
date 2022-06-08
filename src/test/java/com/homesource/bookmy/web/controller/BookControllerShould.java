package com.homesource.bookmy.web.controller;

import com.homesource.bookmy.domain.dto.BookDto;
import com.homesource.bookmy.domain.dto.BookStockDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookControllerShould {

    @Autowired
    private BookController bookController;

    private BookDto mockBookDto;

    @BeforeEach
    void setUp() {
        BookStockDto mockBookStockDto = BookStockDto.builder()
                .loanPrice(1.0)
                .salePrice(1.0)
                .saleUnits(1)
                .loanUnits(1).build();

        mockBookDto = BookDto.builder()
                .tittle("Buscando las estrellas")
                .author("Rafa Mahka")
                .releaseDate(LocalDate.of(1950, 4, 14))
                .pages(124)
                .state("CREADO")
                .stock(mockBookStockDto).build();
    }

    @Test
    @Order(1)
    void findAll() {
        ResponseEntity<List<BookDto>> response = bookController.findAll();
        assertEquals(1, response.getBody().size());
    }

    @Test
    @Order(2)
    void createBook() {
        ResponseEntity<BookDto> response = bookController.createBook(mockBookDto);
        assertEquals(mockBookDto.getAuthor(), response.getBody().getAuthor());
        assertEquals(mockBookDto.getStock().getSalePrice(), response.getBody().getStock().getSalePrice());
        assertEquals(mockBookDto.getPages(), response.getBody().getPages());
    }

    @Test
    @Order(3)
    void findBook() {
        ResponseEntity<BookDto> response = bookController.findBook((long) 2);
        assertEquals(mockBookDto.getTittle(), response.getBody().getTittle());

    }

    @Test
    @Order(4)
    void updateBook() {
        mockBookDto.setAuthor("notfreecap");
        ResponseEntity<BookDto> response = bookController.updateBook((long) 2, mockBookDto);
        assertEquals(mockBookDto.getAuthor(), response.getBody().getAuthor());

    }
}