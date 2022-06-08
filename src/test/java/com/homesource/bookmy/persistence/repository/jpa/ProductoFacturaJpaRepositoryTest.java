package com.homesource.bookmy.persistence.repository.jpa;

import com.homesource.bookmy.persistence.entity.Libro;
import com.homesource.bookmy.persistence.entity.ProductoFactura;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DataJpaTest
class ProductoFacturaJpaRepositoryTest {

    @Autowired
    private ProductoFacturaJpaRepository productoFacturaJpaRepository;

    private ProductoFactura productoFactura;

    @BeforeEach
    void setUp() {
        productoFactura = ProductoFactura.builder()
                .tipoServicio("COMPRA")
                .libro(Libro.builder().id(1L).build())
                .facturaId(1L).build();
    }

    @Test
    void should_add_producto_to_factura(){
        log.info("ProductoFacturaJpaRepositoryTest - should_add_producto_to_factura {}", productoFactura);
        ProductoFactura result = productoFacturaJpaRepository.save(productoFactura);
        assertEquals(productoFactura.getTipoServicio(), result.getTipoServicio());
        assertEquals(productoFactura.getLibro().getId(), result.getLibro().getId());
        assertEquals(productoFactura.getFacturaId(), result.getFacturaId());

    }

    @Test
    void should_find_producto_by_id_and_update_producto(){
        log.info("ProductoFacturaJpaRepositoryTest - should_find_producto_by_id_and_update_producto");
        ProductoFactura findResult = productoFacturaJpaRepository.findById(1L).orElse(null);

        findResult.setTipoServicio("PERSONAL");
        ProductoFactura updateResult = productoFacturaJpaRepository.save(findResult);

        assertNotNull(findResult);
        assertNotNull(updateResult);
        assertEquals(findResult.getTipoServicio(), updateResult.getTipoServicio());
    }

    @Test
    void should_remove_producto_from_factura() {
        log.info("ProductoFacturaJpaRepositoryTest - should_remove_producto_from_factura");
        ProductoFactura findResult = productoFacturaJpaRepository.findById(1L).orElse(null);
        assertNotEquals(null, findResult);
        productoFacturaJpaRepository.delete(findResult);
        findResult = productoFacturaJpaRepository.findById(1L).orElse(null);
        assertNull(findResult);
    }
}