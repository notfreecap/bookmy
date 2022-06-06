package com.homesource.bookmy.web.controller;

import com.homesource.bookmy.domain.dto.BookDto;
import com.homesource.bookmy.domain.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> findAll(){
        return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){
        log.info("Creating Book {}", bookDto);
        return new ResponseEntity<>(bookService.createBook(bookDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> findBook(@PathVariable Long id){
        log.info("Fetching Book with {}", id);
        BookDto bookDto = bookService.findBookById(id);
        if (bookDto == null) {
            log.error("Book with id {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        log.info("Updating Book with id {}", id);
        bookDto.setBookId(id);
        BookDto currentBook = bookService.updateBook(bookDto);
        if (currentBook == null){
            log.error("Unable to update Book with id {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(currentBook, HttpStatus.OK);
    }

    // TODO: Test all methods :D
}
