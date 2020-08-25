package com.example.event.events;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCreatedEvent {
    private String productId;
    private final BigDecimal salePrice;
    private final BigDecimal consumerPrice;
}
