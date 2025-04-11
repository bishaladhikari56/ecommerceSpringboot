package com.example.SpringbootEcommerce2025.controller.admin;

import com.example.SpringbootEcommerce2025.dto.CatgeoryDto;
import com.example.SpringbootEcommerce2025.entity.Category;
import com.example.SpringbootEcommerce2025.services.admin.category.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminCategoreyController {

    private final CategoryService categoryService;

    public AdminCategoreyController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody CatgeoryDto categoryDto){
        Category category=categoryService.createCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }
}
