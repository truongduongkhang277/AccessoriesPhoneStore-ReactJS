package com.java.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.backend.exception.ResourceNotFoundException;
import com.java.backend.model.OrderItems;
import com.java.backend.repository.OrderItemsRepository;

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
public class OrderItemsController {
    @Autowired
    private OrderItemsRepository orderItemsRepository;

    // danh sách đơn đặt hàng
    @GetMapping("/order-items")
    public List<OrderItems> getAllOrderItems() {
        return orderItemsRepository.findAll();
    }

    // thêm đơn đặt hàng
    @PostMapping("/order-items")
    public OrderItems createOrderItems(@RequestBody OrderItems orderItems){
        return orderItemsRepository.save(orderItems);
    }

    // tìm đơn đặt hàng bằng id
    @GetMapping("/order-items/{id}")
    public ResponseEntity<OrderItems> getOrderItemsById(@PathVariable Long id){
        // tìm đơn đặt hàng bằng id nếu không có trả về thông báo lỗi
        OrderItems orderItems = orderItemsRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có đơn đặt hàng có mã: " + id + " !!!"));
        return ResponseEntity.ok(orderItems);
    }

    // cập nhật thông tin đơn đặt hàng
    @PutMapping("/order-items/{id}")
    public ResponseEntity<OrderItems> updateOrderItems(@PathVariable Long id, @RequestBody OrderItems orderItemsDetail){
        OrderItems orderItems = orderItemsRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có đơn đặt hàng có mã: " + id + " !!!"));
        orderItems.setName(orderItemsDetail.getName());
        orderItems.setQuantity(orderItemsDetail.getQuantity());
        orderItems.setImage(orderItemsDetail.getImage());
        orderItems.setPrice(orderItemsDetail.getPrice());
        orderItems.setProduct_id(orderItemsDetail.getProduct_id());

        OrderItems updatedOrderItems = orderItemsRepository.save(orderItems);
        return ResponseEntity.ok(updatedOrderItems);
    }

    // xóa thông tin đơn đặt hàng
    @DeleteMapping("/order-items/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteOrderItems(@PathVariable Long id){
        OrderItems orderItems = orderItemsRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có đơn đặt hàng có mã: " + id + " !!!"));
        orderItemsRepository.delete(orderItems);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Đã xóa", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
