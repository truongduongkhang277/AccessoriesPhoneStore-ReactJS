package com.java.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.backend.exception.ResourceNotFoundException;
import com.java.backend.model.ShippingAddress;
import com.java.backend.repository.ShippingAddressRepository;

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
public class ShippingAddressController {
    @Autowired
    private ShippingAddressRepository shippingAddressRepository;

    // danh sách địa chỉ giao hàng
    @GetMapping("/shipping-address")
    public List<ShippingAddress> getAllShippingAddress() {
        return shippingAddressRepository.findAll();
    }

    // thêm địa chỉ giao hàng
    @PostMapping("/shipping-address")
    public ShippingAddress createShippingAddress(@RequestBody ShippingAddress shippingAddress){
        return shippingAddressRepository.save(shippingAddress);
    }

    // tìm địa chỉ giao hàng bằng id
    @GetMapping("/shipping-address/{id}")
    public ResponseEntity<ShippingAddress> getShippingAddressById(@PathVariable Long id){
        // tìm địa chỉ giao hàng bằng id nếu không có trả về thông báo lỗi
        ShippingAddress shippingAddress = shippingAddressRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có địa chỉ giao hàng có mã: " + id + " !!!"));
        return ResponseEntity.ok(shippingAddress);
    }

    // cập nhật thông tin địa chỉ giao hàng
    @PutMapping("/shipping-address/{id}")
    public ResponseEntity<ShippingAddress> updateShippingAddress(@PathVariable Long id, @RequestBody ShippingAddress ShippingAddressDetail){
        ShippingAddress shippingAddress = shippingAddressRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có địa chỉ giao hàng có mã: " + id + " !!!"));
        shippingAddress.setFullname(ShippingAddressDetail.getFullname());
        shippingAddress.setAddress(ShippingAddressDetail.getAddress());
        shippingAddress.setCity(ShippingAddressDetail.getCity());
        shippingAddress.setCountry(ShippingAddressDetail.getCountry());
        shippingAddress.setPostal_code(ShippingAddressDetail.getPostal_code());

        ShippingAddress updatedShippingAddress = shippingAddressRepository.save(shippingAddress);
        return ResponseEntity.ok(updatedShippingAddress);
    }

    // xóa thông tin địa chỉ giao hàng
    @DeleteMapping("/shipping-address/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteShippingAddress(@PathVariable Long id){
        ShippingAddress shippingAddress = shippingAddressRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có địa chỉ giao hàng có mã: " + id + " !!!"));
        shippingAddressRepository.delete(shippingAddress);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Đã xóa", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
