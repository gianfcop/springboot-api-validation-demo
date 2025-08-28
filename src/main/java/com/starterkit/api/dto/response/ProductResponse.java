/*
 * Spring Boot API Starter Kit
 * Copyright (c) 2025 Gianfranco Coppola. All rights reserved.
 * Commercial use permitted. Redistribution prohibited.
 */
package com.starterkit.api.dto.response;

import java.time.LocalDate;
import java.util.List;

import lombok.*;
import lombok.experimental.FieldDefaults;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {

    @Schema(description = "Unique identifier of the product", example = "101")
    Long id;

    @Schema(description = "Product name", example = "iPhone 15 Pro")
    String name;

    @Schema(description = "Price of the product", example = "999.99")
    Double price;

    @Schema(description = "Stock Keeping Unit (SKU)", example = "AB12CD34")
    String sku;

    @Schema(description = "Tags associated with the product", example = "[\"smartphone\", \"apple\", \"premium\"]")
    List<String> tags;
    
    @Schema(description = "Email for warranty support", example = "support@example.com")
    String emailForWarranty;

    @Schema(description = "Discount percentage", example = "15")
    Integer discountPercentage;

    @Schema(description = "Availability date", example = "2025-01-15")
    LocalDate availabilityDate;

    @Schema(description = "Category name", example = "Electronics")
    String category;
}

