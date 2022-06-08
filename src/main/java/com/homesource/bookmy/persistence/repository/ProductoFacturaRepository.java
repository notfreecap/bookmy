package com.homesource.bookmy.persistence.repository;

import com.homesource.bookmy.domain.dto.CartItemDto;
import com.homesource.bookmy.domain.repository.CartItemRepository;
import com.homesource.bookmy.persistence.entity.ProductoFactura;
import com.homesource.bookmy.persistence.mapper.CartItemMapper;
import com.homesource.bookmy.persistence.repository.jpa.ProductoFacturaJpaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class ProductoFacturaRepository implements CartItemRepository {

    private final ProductoFacturaJpaRepository productoFacturaJpaRepository;

    private final CartItemMapper mapper;

    @Override
    public CartItemDto createCartItem(CartItemDto cartItemDto) {
        ProductoFactura productoFactura = mapper.toProductoFactura(cartItemDto);
        return mapper.toCartItem(productoFacturaJpaRepository.save(productoFactura));
    }

    @Override
    public CartItemDto updateCartItem(CartItemDto cartItemDto) {
        ProductoFactura productoFactura = mapper.toProductoFactura(cartItemDto);
        return mapper.toCartItem(productoFacturaJpaRepository.save(productoFactura));
    }

    @Override
    public boolean deleteCartItem(Long id) {
        ProductoFactura productoFactura = productoFacturaJpaRepository.findById(id).orElse(null);
        if (productoFactura == null)
            return false;

        productoFacturaJpaRepository.delete(productoFactura);
        return true;
    }
}
