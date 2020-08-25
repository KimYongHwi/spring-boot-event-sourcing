package com.example.event.events;

import java.math.BigDecimal;

import lombok.Value;

@Value
public class ProductUpdatedEvent {  
    private String productId;
    private final BigDecimal salePrice;
    private final BigDecimal consumerPrice;
}
