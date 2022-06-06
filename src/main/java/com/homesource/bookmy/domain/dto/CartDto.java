package com.homesource.bookmy.domain.dto;

import com.homesource.bookmy.domain.enumeration.PaymentMethod;
import com.homesource.bookmy.domain.enumeration.PaymentStatus;
import com.homesource.bookmy.persistence.entity.Persona;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class CartDto {
    private Long cartId;
    private LocalDateTime createdAt;
    private LocalDateTime paymentDate;
    private double total;
    private String paymentMethod;
    private String paymentStatus;
    private PersonDto customer;
    private List<CartItemDto> items;
}
