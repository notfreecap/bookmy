package com.homesource.bookmy.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookStockDto {

    private Integer loanUnits;

    private Double loanPrice;

    private Integer saleUnits;

    private Double salePrice;
}
