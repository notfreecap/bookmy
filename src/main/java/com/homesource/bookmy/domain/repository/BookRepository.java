package com.homesource.bookmy.domain.repository;

import com.homesource.bookmy.domain.dto.BookDto;

import java.util.List;

public interface BookRepository {

    List<BookDto> getAll();

    BookDto createBook(BookDto bookDto);

    BookDto findBookById(Long id);

    BookDto updateBook(BookDto bookDto);

}
