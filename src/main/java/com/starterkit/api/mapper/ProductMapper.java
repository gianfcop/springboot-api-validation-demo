/*
 * Spring Boot API Starter Kit
 * Copyright (c) 2025 Gianfranco Coppola. All rights reserved.
 * Commercial use permitted. Redistribution prohibited.
 */
package com.starterkit.api.mapper;

import com.starterkit.api.dto.request.ProductRequest;
import com.starterkit.api.dto.response.ProductResponse;
import com.starterkit.api.entity.Category;
import com.starterkit.api.entity.Product;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ProductMapper {

    public ProductResponse toResponse(Product product) {
        if (product == null) return null;

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .sku(product.getSku())
                .tags(product.getTags())
                .emailForWarranty(product.getEmailForWarranty())
                .discountPercentage(product.getDiscountPercentage())
                .availabilityDate(product.getAvailabilityDate())
                .category(product.getCategory() != null ? product.getCategory().getName() : null)
                .build();
    }

    public List<ProductResponse> toResponseList(List<Product> products) {
        return products.stream()
                .map(ProductMapper::toResponse)
                .toList();
    }

    public Product toEntity(ProductRequest request, Category category) {
        return Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .sku(request.getSku())
                .emailForWarranty(request.getEmailForWarranty())
                .discountPercentage(request.getDiscountPercentage())
                .availabilityDate(request.getAvailabilityDate())
                .createdAt(request.getCreatedAt().atStartOfDay())
                .category(category)
                .tags(request.getTags())
                .build();
    }
}
