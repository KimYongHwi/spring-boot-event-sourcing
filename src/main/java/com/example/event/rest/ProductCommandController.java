package com.example.event.rest;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.concurrent.CompletableFuture;

import com.example.event.domain.entities.Product;
import com.example.event.rest.dto.ProductCreateAndUpdateDTO;
import com.example.event.services.ProductCommandService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/products")
@Api(value = "Product Commands", description = "Product Commands API")
@AllArgsConstructor
public class ProductCommandController {
    
    private final ProductCommandService productCommandService;

    @PostMapping
    @ResponseStatus(value = CREATED)
    public CompletableFuture<Product> createProduct(@RequestBody ProductCreateAndUpdateDTO dto) {
        return this.productCommandService.createProduct(dto);
    }

    @PutMapping(value = "/{ProductId}")
    public CompletableFuture<Product> updateProduct(@PathVariable(value = "ProductId") String productId,
                                                            @RequestBody ProductCreateAndUpdateDTO dto
    ) {
        return this.productCommandService.updateProduct(productId, dto);
    }
}
