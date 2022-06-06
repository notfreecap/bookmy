package com.homesource.bookmy.persistence.repository;

import com.homesource.bookmy.domain.dto.CartDto;
import com.homesource.bookmy.domain.repository.CartRepository;
import com.homesource.bookmy.persistence.entity.Factura;
import com.homesource.bookmy.persistence.mapper.CartMapper;
import com.homesource.bookmy.persistence.repository.jpa.FacturaJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class FacturaRepository implements CartRepository {


    private final FacturaJpaRepository facturaJpaRepository;

    private final CartMapper mapper;

    @Override
    public List<CartDto> findAll(){
        return mapper.toCartList(facturaJpaRepository.findAll());
    }

    @Override
    public CartDto createFactura(CartDto cartDto){
        Factura factura = mapper.toFactura(cartDto);
        return mapper.toCart(facturaJpaRepository.save(factura));
    }

    @Override
    public CartDto findById(Long id){
        Factura factura = facturaJpaRepository.findById(id).orElse(null);
        return mapper.toCart(factura);
    }

    @Override
    public CartDto updateFactura(CartDto cartDto){
        Factura factura = mapper.toFactura(cartDto);
        return mapper.toCart(facturaJpaRepository.save(factura));
    }


}
