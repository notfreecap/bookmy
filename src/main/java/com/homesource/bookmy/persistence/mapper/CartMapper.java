package com.homesource.bookmy.persistence.mapper;

import com.homesource.bookmy.domain.dto.CartDto;
import com.homesource.bookmy.persistence.entity.Factura;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {CartItemMapper.class, PersonMapper.class}
)
public interface CartMapper {

    @Mappings({
            @Mapping(source = "id", target = "cartId"),
            @Mapping(source = "fechaCreacion", target = "createdAt"),
            @Mapping(source = "fechaPago", target = "paymentDate"),
            @Mapping(source = "totalPago", target = "total"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "estadoPago", target = "paymentStatus"),
            @Mapping(source = "cliente", target = "customer"),
            @Mapping(source = "productos", target = "items")
    })
    CartDto toCart(Factura factura);
    List<CartDto> toCartList(List<Factura> factura);

    @InheritInverseConfiguration
    Factura toFactura(CartDto cartDto);

}
