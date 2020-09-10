package com.example.event.aggregates;

import java.math.BigDecimal;
import java.util.List;

import com.example.event.commands.CreateProductCommand;
import com.example.event.commands.UpdateProductCommand;
import com.example.event.domain.entities.ProductImage;
import com.example.event.events.ProductCreatedEvent;
import com.example.event.events.ProductUpdatedEvent;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String id;
    private BigDecimal salePrice;
    private BigDecimal consumerPrice;
    private List<ProductImage> productImages;

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        AggregateLifecycle.apply(
            new ProductCreatedEvent(
                command.getProductId(),
                command.getSalePrice(),
                command.getConsumerPrice(),
                command.getProductImages()
            )
        );
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.id = event.getProductId();
        this.salePrice = event.getSalePrice();
        this.consumerPrice = event.getConsumerPrice();
        this.productImages = event.getProductImages();
    }

    @CommandHandler
    public void handle(UpdateProductCommand command) {
        AggregateLifecycle.apply(
                new ProductUpdatedEvent(command.getProductId(), command.getSalePrice(), command.getConsumerPrice()));
    }

    @EventSourcingHandler
    public void on(ProductUpdatedEvent event) {
        this.salePrice = event.getSalePrice();
        this.consumerPrice = event.getConsumerPrice();
    }
}
