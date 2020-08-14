package com.example.event.rest.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SiteProductCreationDTO {
    private BigDecimal salePrice;
    private BigDecimal consumerPrice;
}
