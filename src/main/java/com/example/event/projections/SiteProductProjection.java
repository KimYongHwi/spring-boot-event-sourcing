package com.example.event.projections;

import com.example.event.domain.entities.SiteProduct;
import com.example.event.domain.repository.SiteProductRepository;
import com.example.event.events.SiteProductCreatedEvent;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SiteProductProjection {

    private final SiteProductRepository repository;
    
    @EventHandler
    public void on(SiteProductCreatedEvent event) {
        SiteProduct siteProduct = new SiteProduct(
            event.getId(),
            event.getSalePrice(),
            event.getConsumerPrice()
        );

        this.repository.save(siteProduct);
    }
}
