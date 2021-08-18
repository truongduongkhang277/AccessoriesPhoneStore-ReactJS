package com.java.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.backend.exception.ResourceNotFoundException;
import com.java.backend.model.Category;
import com.java.backend.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class CategoryController {
    
    @Autowired
    private CategoryRepository categoryRepository;

    // danh sách loại sản phẩm
    @GetMapping("/categories")
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    // thêm loại sản phẩm
    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }

    // tìm loại sản phẩm bằng id
    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        // tìm loại sản phẩm bằng id nếu không có trả về thông báo lỗi
        Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có loại sản phẩm có mã: " + id + " !!!"));
        return ResponseEntity.ok(category);
    }

    // cập nhật thông tin loại sản phẩm
    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetail){
        Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có loại sản phẩm có mã: " + id + " !!!"));
        category.setName(categoryDetail.getName());

        Category updatedCategory = categoryRepository.save(category);
        return ResponseEntity.ok(updatedCategory);
    }

    // xóa thông tin loại sản phẩm
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCategory(@PathVariable Long id){
        Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có loại sản phẩm có mã: " + id + " !!!"));
            categoryRepository.delete(category);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Đã xóa", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
