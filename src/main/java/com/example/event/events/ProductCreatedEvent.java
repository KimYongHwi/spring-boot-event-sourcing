package com.example.event.events;

import java.math.BigDecimal;
import java.util.List;

import com.example.event.domain.entities.ProductImage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCreatedEvent {
    private String productId;
    private final BigDecimal salePrice;
    private final BigDecimal consumerPrice;
    private final List<ProductImage> productImages;
}
