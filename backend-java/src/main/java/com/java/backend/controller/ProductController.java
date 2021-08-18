package com.java.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.backend.exception.ResourceNotFoundException;
import com.java.backend.model.Product;
import com.java.backend.repository.ProductRepository;

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
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    // danh sách sản phẩm
    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    // thêm sản phẩm
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    // tìm sản phẩm bằng id
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        // tìm sản phẩm bằng id nếu không có trả về thông báo lỗi
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có sản phẩm có mã: " + id + " !!!"));
        return ResponseEntity.ok(product);
    }

    // cập nhật thông tin sản phẩm
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetail){
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có sản phẩm có mã: " + id + " !!!"));
        product.setName(productDetail.getName());
        product.setCost(productDetail.getCost());
        product.setPrice(productDetail.getPrice());
        product.setImage(productDetail.getImage());
        product.setCount_in_stock(productDetail.getCount_in_stock());
        product.setRating(productDetail.getRating());
        product.setNum_reviews(productDetail.getNum_reviews());
        product.setDescription(productDetail.getDescription());
        product.setBrand_id(productDetail.getBrand_id());
        product.setCategory_id(productDetail.getCategory_id());

        Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    // xóa thông tin sản phẩm
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id){
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có sản phẩm có mã: " + id + " !!!"));
            productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Đã xóa", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
