package com.example.event.events;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SiteProductCreatedEvent {

    private Long id;
    private final BigDecimal salePrice;
    private final BigDecimal consumerPrice;
}
