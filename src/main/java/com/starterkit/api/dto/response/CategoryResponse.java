/*
 * Spring Boot API Starter Kit
 * Copyright (c) 2025 Gianfranco Coppola. All rights reserved.
 * Commercial use permitted. Redistribution prohibited.
 */
package com.starterkit.api.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryResponse {

    @Schema(description = "Unique identifier of the category", example = "1")
    Long id;

    @Schema(description = "Category name", example = "Electronics")
    String name;

    @Schema(description = "Description of the category", example = "All kinds of electronic devices and accessories")
    String description;
}
