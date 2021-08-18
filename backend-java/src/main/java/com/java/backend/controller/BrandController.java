package com.java.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.backend.exception.ResourceNotFoundException;
import com.java.backend.model.Brand;
import com.java.backend.repository.BrandRepository;

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
public class BrandController {
    
    @Autowired
    private BrandRepository brandRepository;

    // danh sách thương hiệu
    @GetMapping("/brands")
    public List<Brand> getAllBrand() {
        return brandRepository.findAll();
    }

    // thêm thương hiệu
    @PostMapping("/brands")
    public Brand createBrand(@RequestBody Brand brand){
        return brandRepository.save(brand);
    }

    // tìm thương hiệu bằng id
    @GetMapping("/brands/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Long id){
        // tìm thương hiệu bằng id nếu không có trả về thông báo lỗi
        Brand brand = brandRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có thương hiệu có mã: " + id + " !!!"));
        return ResponseEntity.ok(brand);
    }

    // cập nhật thông tin thương hiệu
    @PutMapping("/brands/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @RequestBody Brand brandDetail){
        Brand brand = brandRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có thương hiệu có mã: " + id + " !!!"));
        brand.setName(brandDetail.getName());

        Brand updatedBrand = brandRepository.save(brand);
        return ResponseEntity.ok(updatedBrand);
    }

    // xóa thông tin thương hiệu
    @DeleteMapping("/brands/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBrand(@PathVariable Long id){
        Brand brand = brandRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có thương hiệu có mã: " + id + " !!!"));
            brandRepository.delete(brand);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Đã xóa", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
