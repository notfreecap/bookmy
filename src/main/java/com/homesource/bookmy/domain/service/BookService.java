package com.homesource.bookmy.domain.service;

import com.homesource.bookmy.domain.dto.BookDto;
import com.homesource.bookmy.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> findAllBooks(){
        return bookRepository.getAll();
    }

    public BookDto createBook(BookDto bookDto){
        return bookRepository.createBook(bookDto);
    }

    public BookDto findBookById(Long id){
        return bookRepository.findBookById(id);
    }

    public BookDto updateBook(BookDto bookDto){
        return bookRepository.updateBook(bookDto);
    }

}
