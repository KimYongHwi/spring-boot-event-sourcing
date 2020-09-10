package com.example.event.handlers;

import java.util.Optional;

import javax.transaction.Transactional;

import com.example.event.domain.entities.Product;
import com.example.event.domain.repository.ProductRepository;
import com.example.event.events.ProductCreatedEvent;
import com.example.event.events.ProductUpdatedEvent;
import com.example.event.exceptions.ProductNotFoundException;
import com.example.event.queries.FindProductByIdQuery;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductHandler {

    private final ProductRepository repository;
    
    @EventHandler
    @Transactional
    public void on(ProductCreatedEvent event) {
        Product product = new Product();

        product.setProductId(Long.parseLong(event.getProductId()));
        product.setSalePrice(event.getSalePrice());
        product.setConsumerPrice(event.getConsumerPrice());
        event.getProductImages().stream().forEach(productImage -> {
            product.addProductImage(productImage);
        });

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

    @QueryHandler
    public Product handle(FindProductByIdQuery query) {
        log.info("Handling FindProductByIdQuery query: {}", query);
        return this.repository.findById(query.getProductId()).orElse(null);
    }
}
