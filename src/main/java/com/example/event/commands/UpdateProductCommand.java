package com.example.event.commands;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductCommand {

    @TargetAggregateIdentifier
    private String productId;
    private BigDecimal salePrice;
    private BigDecimal consumerPrice;
}
