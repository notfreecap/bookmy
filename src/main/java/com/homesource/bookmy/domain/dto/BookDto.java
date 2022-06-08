package com.homesource.bookmy.domain.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class BookDto {

    private Long bookId;
    private String tittle;
    private String author;
    private LocalDate releaseDate;
    private int pages;
    private String state;
    private BookStockDto stock;

}
