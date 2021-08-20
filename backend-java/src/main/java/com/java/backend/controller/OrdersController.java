package com.java.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.backend.exception.ResourceNotFoundException;
import com.java.backend.model.Orders;
import com.java.backend.repository.OrdersRepository;

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
public class OrdersController {
    @Autowired
    private OrdersRepository ordersRepository;

    // danh sách đơn hàng
    @GetMapping("/orders")
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    // thêm đơn hàng
    @PostMapping("/orders")
    public Orders createOrders(@RequestBody Orders Orders){
        return ordersRepository.save(Orders);
    }

    // tìm đơn hàng bằng id
    @GetMapping("/orders/{id}")
    public ResponseEntity<Orders> getOrdersById(@PathVariable Long id){
        // tìm đơn hàng bằng id nếu không có trả về thông báo lỗi
        Orders orders = ordersRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có đơn hàng có mã: " + id + " !!!"));
        return ResponseEntity.ok(orders);
    }

    // cập nhật thông tin đơn hàng
    @PutMapping("/orders/{id}")
    public ResponseEntity<Orders> updateOrders(@PathVariable Long id, @RequestBody Orders ordersDetail){
        Orders orders = ordersRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có đơn hàng có mã: " + id + " !!!"));
        orders.setOrderItems(ordersDetail.getOrderItems());
        orders.setShippingAddress(ordersDetail.getShippingAddress());
        orders.setPaymentMethod(ordersDetail.getPaymentMethod());
        orders.setUser(ordersDetail.getUser());
        orders.setItemPrice(ordersDetail.getItemPrice());
        orders.setShippingPrice(ordersDetail.getShippingPrice());
        orders.setTaxPrice(ordersDetail.getTaxPrice());
        orders.setTotalPrice(ordersDetail.getTotalPrice());
        orders.setIsPaid(ordersDetail.getIsPaid());
        orders.setPaidAt(ordersDetail.getPaidAt());
        orders.setIsDelivered(ordersDetail.getIsDelivered());
        orders.setDeliveredAt(ordersDetail.getDeliveredAt());

        Orders updatedOrders = ordersRepository.save(orders);
        return ResponseEntity.ok(updatedOrders);
    }

    // xóa thông tin đơn hàng
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteOrders(@PathVariable Long id){
        Orders orders = ordersRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có đơn hàng có mã: " + id + " !!!"));
            ordersRepository.delete(orders);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Đã xóa", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
