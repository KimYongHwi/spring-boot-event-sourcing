package com.example.event.commands;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSiteProductCommand {
    
    @TargetAggregateIdentifier
    private Long siteProductId;
    private BigDecimal salePrice;
    private BigDecimal consumerPrice;
}
