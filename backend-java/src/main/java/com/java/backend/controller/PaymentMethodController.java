package com.java.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.backend.exception.ResourceNotFoundException;
import com.java.backend.model.PaymentMethod;
import com.java.backend.repository.PaymentMethodRepository;

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
public class PaymentMethodController {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    // danh sách phương thức thanh toán
    @GetMapping("/payment-methods")
    public List<PaymentMethod> getAllPaymentMethod() {
        return paymentMethodRepository.findAll();
    }

    // thêm phương thức thanh toán
    @PostMapping("/payment-methods")
    public PaymentMethod createPaymentMethod(@RequestBody PaymentMethod paymentMethod){
        return paymentMethodRepository.save(paymentMethod);
    }

    // tìm phương thức thanh toán bằng id
    @GetMapping("/payment-methods/{id}")
    public ResponseEntity<PaymentMethod> getPaymentMethodById(@PathVariable Long id){
        // tìm phương thức thanh toán bằng id nếu không có trả về thông báo lỗi
        PaymentMethod PaymentMethod = paymentMethodRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có phương thức thanh toán có mã: " + id + " !!!"));
        return ResponseEntity.ok(PaymentMethod);
    }

    // cập nhật thông tin phương thức thanh toán
    @PutMapping("/payment-methods/{id}")
    public ResponseEntity<PaymentMethod> updatePaymentMethod(@PathVariable Long id, @RequestBody PaymentMethod paymentMethodDetail){
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có phương thức thanh toán có mã: " + id + " !!!"));
        paymentMethod.setName(paymentMethodDetail.getName());

        PaymentMethod updatedPaymentMethod = paymentMethodRepository.save(paymentMethod);
        return ResponseEntity.ok(updatedPaymentMethod);
    }

    // xóa thông tin phương thức thanh toán
    @DeleteMapping("/payment-methods/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePaymentMethod(@PathVariable Long id){
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có phương thức thanh toán có mã: " + id + " !!!"));
        paymentMethodRepository.delete(paymentMethod);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Đã xóa", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
