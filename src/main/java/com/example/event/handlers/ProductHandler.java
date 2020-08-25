package com.example.event.handlers;

import java.util.Optional;

import com.example.event.domain.entities.Product;
import com.example.event.domain.repository.ProductRepository;
import com.example.event.events.ProductCreatedEvent;
import com.example.event.events.ProductUpdatedEvent;
import com.example.event.exceptions.ProductNotFoundException;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductHandler {

    private final ProductRepository repository;
    
    @EventHandler
    public void on(ProductCreatedEvent event) {
        Product product = new Product(
            Long.parseLong(event.getProductId()),
            event.getSalePrice(),
            event.getConsumerPrice()
        );

        this.repository.save(product);
    }

    @EventHandler
    public void on(ProductUpdatedEvent event) throws ProductNotFoundException {
        Optional<Product> optionalProduct = this.repository.findById(Long.parseLong(event.getProductId()));
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setSalePrice(event.getSalePrice());
            product.setConsumerPrice(event.getConsumerPrice());
            
            this.repository.save(product);
        } else {
            throw new ProductNotFoundException(event.getProductId());
        }
    }
}
