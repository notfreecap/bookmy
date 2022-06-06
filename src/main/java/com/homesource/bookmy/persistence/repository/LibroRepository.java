package com.homesource.bookmy.persistence.repository;

import com.homesource.bookmy.domain.dto.BookDto;
import com.homesource.bookmy.domain.repository.BookRepository;
import com.homesource.bookmy.persistence.entity.Libro;
import com.homesource.bookmy.persistence.mapper.BookMapper;
import com.homesource.bookmy.persistence.repository.jpa.LibroJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LibroRepository implements BookRepository {

    @Autowired
    private LibroJpaRepository libroJpaRepository;

    @Autowired
    private BookMapper mapper;

    @Override
    public List<BookDto> getAll() {
        return mapper.toBookDtoList(libroJpaRepository.findAll());
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Libro libro = mapper.toLibro(bookDto);
        return mapper.toBookDto(libroJpaRepository.save(libro));
    }

    @Override
    public BookDto findBookById(Long id) {
        Libro libro = libroJpaRepository.findById(id).orElse(null);
        return mapper.toBookDto(libro);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        Libro libroUpdate = mapper.toLibro(bookDto);
        Libro libroDB = libroJpaRepository.findById(libroUpdate.getId()).orElse(null);
        if (libroDB == null)
            return null;

        libroDB.setNombre(libroUpdate.getNombre());
        libroDB.setAutor(libroUpdate.getAutor());
        libroDB.setFechaLanzamiento(libroUpdate.getFechaLanzamiento());
        libroDB.setPaginas(libroUpdate.getPaginas());
        libroDB.setEstado(libroUpdate.getEstado());

        return mapper.toBookDto(libroJpaRepository.save(libroDB));
    }
}
