package com.java.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.backend.exception.ResourceNotFoundException;
import com.java.backend.model.Customer;
import com.java.backend.repository.CustomerRepository;

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
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // danh sách khách hàng
    @GetMapping("/customers")
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    // thêm khách hàng
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    // tìm khách hàng bằng id
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        // tìm khách hàng bằng id nếu không có trả về thông báo lỗi
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có khách hàng có mã: " + id + " !!!"));
        return ResponseEntity.ok(customer);
    }

    // cập nhật thông tin khách hàng
    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetail){
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có khách hàng có mã: " + id + " !!!"));
        customer.setName(customerDetail.getName());
        customer.setAddress(customerDetail.getAddress());
        customer.setEmail(customerDetail.getEmail());
        customer.setPhone(customerDetail.getPhone());

        Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    // xóa thông tin khách hàng
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id){
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có khách hàng có mã: " + id + " !!!"));
        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}