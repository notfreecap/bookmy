package com.homesource.bookmy.domain.dto;

import com.homesource.bookmy.domain.enumeration.ProductType;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class CartItemDto {
    private Long itemId;
    private LocalDateTime addedAt;
    private String type;
    private BookDto book;
}
