package com.homesource.bookmy.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Builder
public class BookDto {

    private Long bookId;
    private String tittle;
    private String author;
    private LocalDate releaseDate;
    private int pages;
    private String state;
    private BookStockDto stock;

}
