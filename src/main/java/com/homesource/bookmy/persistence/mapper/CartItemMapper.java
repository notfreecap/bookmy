package com.homesource.bookmy.persistence.mapper;

import com.homesource.bookmy.domain.dto.CartItemDto;
import com.homesource.bookmy.persistence.entity.ProductoFactura;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {BookMapper.class})
public interface CartItemMapper {

    @Mappings({
            @Mapping(source = "id", target = "itemId"),
            @Mapping(source = "fechaCreacion", target = "addedAt"),
            @Mapping(source = "tipoServicio", target = "type"),
            @Mapping(source = "libro", target = "book")
    })
    CartItemDto toCartItem(ProductoFactura productoFactura);
    List<CartItemDto> toCartItemList(List<ProductoFactura> productoFactura);

    @InheritInverseConfiguration
    ProductoFactura toProductoFactura(CartItemDto cartItemDto);
}
