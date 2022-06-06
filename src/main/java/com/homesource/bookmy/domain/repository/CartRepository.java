package com.homesource.bookmy.domain.repository;

import com.homesource.bookmy.domain.dto.CartDto;
import com.homesource.bookmy.domain.dto.CartItemDto;
import com.homesource.bookmy.persistence.entity.Factura;
import com.homesource.bookmy.persistence.repository.jpa.FacturaJpaRepository;

import java.util.List;

public interface CartRepository {

    public List<CartDto> findAll();

    public CartDto createFactura(CartDto cartDto);

    public CartDto findById(Long id);

    public CartDto updateFactura(CartDto cartDto);
}
