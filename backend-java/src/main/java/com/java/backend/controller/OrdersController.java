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
        orders.setOrder_item_id(ordersDetail.getOrder_item_id());
        orders.setShipping_address_id(ordersDetail.getShipping_address_id());
        orders.setPayment_method_id(ordersDetail.getPayment_method_id());
        orders.setUser_id(ordersDetail.getUser_id());
        orders.setItem_price(ordersDetail.getItem_price());
        orders.setShipping_price(ordersDetail.getShipping_price());
        orders.setTax_price(ordersDetail.getTax_price());
        orders.setTotal_price(ordersDetail.getTotal_price());
        orders.setIs_paid(ordersDetail.getIs_paid());
        orders.setPaid_at(ordersDetail.getPaid_at());
        orders.setIs_delivered(ordersDetail.getIs_delivered());
        orders.setDelivered_at(ordersDetail.getDelivered_at());

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
