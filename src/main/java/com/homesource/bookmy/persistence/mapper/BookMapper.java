package com.homesource.bookmy.persistence.mapper;

import com.homesource.bookmy.domain.dto.BookDto;
import com.homesource.bookmy.persistence.entity.Libro;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {BookStockMapper.class})
public interface BookMapper {

    @Mappings({
            @Mapping(source = "id", target = "bookId"),
            @Mapping(source = "nombre", target = "tittle"),
            @Mapping(source = "autor", target = "author"),
            @Mapping(source = "fechaLanzamiento", target = "releaseDate"),
            @Mapping(source = "paginas", target = "pages"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "libroStock", target = "stock")
    })
    BookDto toBookDto(Libro libro);
    List<BookDto> toBookDtoList (List<Libro> libros);


    @InheritInverseConfiguration
    Libro toLibro(BookDto bookDto);
}
