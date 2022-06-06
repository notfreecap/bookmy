package com.homesource.bookmy.persistence.mapper;

import com.homesource.bookmy.domain.dto.BookStockDto;
import com.homesource.bookmy.persistence.entity.LibroStock;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookStockMapper {

    @Mappings({
            @Mapping(source = "unidadesPrestamo", target = "loanUnits"),
            @Mapping(source = "valorPrestamo", target = "loanPrice"),
            @Mapping(source = "unidadesVenta", target = "saleUnits"),
            @Mapping(source = "valorVenta", target = "salePrice")
    })
    BookStockDto toBookStockDto(LibroStock libroStock);

    @InheritInverseConfiguration
    LibroStock toLibroStock(BookStockDto bookStockDto);
}
