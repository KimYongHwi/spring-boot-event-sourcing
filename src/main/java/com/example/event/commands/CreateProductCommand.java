package com.example.event.commands;

import java.math.BigDecimal;
import java.util.List;

import com.example.event.domain.entities.ProductImage;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductCommand {
    
    @TargetAggregateIdentifier
    private String productId;
    private BigDecimal salePrice;
    private BigDecimal consumerPrice;
    private List<ProductImage> productImages;
}
