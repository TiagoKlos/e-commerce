package com.tads.ecommerce.dto;

import com.tads.ecommerce.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO(@NonNull Category entity) {
        id = entity.getId();
        name = entity.getName();

    }
}

