package com.tads.ecommerce.resource;

import com.tads.ecommerce.entity.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping (value = "/categories")

public class CategoryResource {
    @GetMapping

    public ResponseEntity <List<Category>> findAll(){
        List<Category> list = new ArrayList<>();
        list.add(new Category(1L, "Books"));
        list.add(new Category(2L, "Eletronics"));

        return ResponseEntity.ok(list);
    }

}
