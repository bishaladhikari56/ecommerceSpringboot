package com.example.SpringbootEcommerce2025.services.admin.category;

import com.example.SpringbootEcommerce2025.dto.CatgeoryDto;
import com.example.SpringbootEcommerce2025.entity.Category;
//category service
public interface CategoryService {
    Category createCategory(CatgeoryDto categoryDto);
}
