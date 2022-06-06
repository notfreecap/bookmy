package com.homesource.bookmy.persistence.mapper;

import com.homesource.bookmy.domain.dto.CartDto;
import com.homesource.bookmy.persistence.entity.Factura;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CartMapperTest {



    //CartMapper cartMapper;

    @BeforeEach
    void setUp() {
        //cartMapper = new CartMapper();
    }

    @Test
    void should_map_to_factura_to_cary(){
        /*Factura factura = Factura.builder()
                .totalPago(10.0)
                .build();
        CartDto cartDto = cartMapper.toCart(factura);
        assertEquals(factura.getTotalPago(), cartDto.getTotal());*/
    }
}