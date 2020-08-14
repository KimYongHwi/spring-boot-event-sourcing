package com.example.event.aggregates;

import java.math.BigDecimal;

import com.example.event.commands.CreateSiteProductCommand;
import com.example.event.events.SiteProductCreatedEvent;

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
public class SiteProductAggregate {

    @AggregateIdentifier
    private long siteProductId;
    
    private BigDecimal salePrice;

    private BigDecimal consumerPrice;

    @CommandHandler
    public SiteProductAggregate(CreateSiteProductCommand command) {
        AggregateLifecycle.apply(
            new SiteProductCreatedEvent(
                command.getSiteProductId(),
                command.getSalePrice(),
                command.getConsumerPrice()
            )
        );
    }

    @EventSourcingHandler
    public void on(SiteProductCreatedEvent event) {
        this.siteProductId = event.getId();
        this.salePrice = event.getSalePrice();
        this.consumerPrice = event.getConsumerPrice();
    }
}
