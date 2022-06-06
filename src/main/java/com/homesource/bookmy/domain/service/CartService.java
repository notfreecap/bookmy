package com.homesource.bookmy.domain.service;

import com.homesource.bookmy.domain.dto.CartDto;
import com.homesource.bookmy.domain.repository.CartRepository;
import com.homesource.bookmy.persistence.entity.Factura;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public List<CartDto> findAll(){
        return cartRepository.findAll();
    };

    public CartDto createFactura(CartDto cartDto){
        return cartRepository.createFactura(cartDto);
    };

    public CartDto findById(Long id){
        return cartRepository.findById(id);
    };

    public CartDto updateFactura(CartDto cartDto){
        return updateFactura(cartDto);
    };

}
