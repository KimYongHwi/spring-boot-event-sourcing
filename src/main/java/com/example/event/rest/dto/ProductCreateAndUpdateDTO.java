package com.example.event.rest.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.example.event.domain.entities.ProductImage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateAndUpdateDTO {
    private BigDecimal salePrice;
    private BigDecimal consumerPrice;
    private List<String> productImageUrls;
    private List<String> productImageTypes;

    public List<ProductImage> getProductImages() {
        List<ProductImage> productImages = new ArrayList();

        IntStream.range(0, productImageUrls.size()).forEach(i -> {
            productImages.add(new ProductImage(productImageUrls.get(i), productImageTypes.get(i)));
        });

        return productImages;
    }
}
