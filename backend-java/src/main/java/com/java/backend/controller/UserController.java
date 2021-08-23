package com.java.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.backend.exception.ResourceNotFoundException;
import com.java.backend.model.User;
import com.java.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class UserController {

    @Autowired
    private UserRepository userRepository;

    PasswordEncoder encoder = new BCryptPasswordEncoder();

    // danh sách khách hàng
    @GetMapping("/users")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    // thêm khách hàng
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // tìm khách hàng bằng id
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        // tìm khách hàng bằng id nếu không có trả về thông báo lỗi
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có khách hàng có mã: " + id + " !!!"));
        return ResponseEntity.ok(user);
    }

    // đăng nhập
    @PostMapping("/signin/{email}/{password}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email,@PathVariable String password){
        // tìm khách hàng bằng email nếu không có trả về rỗng
        User user = userRepository.findByEmail(email);
        // nếu có user và pass truyền vào trùng với pass của user thì trả về user
        if(user != null && encoder.matches(password, user.getPassword())){
            return ResponseEntity.ok(user);
        }
        return null;
    }

    // cập nhật thông tin khách hàng
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetail){
        
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có khách hàng có mã: " + id + " !!!"));
        user.setName(userDetail.getName());
        user.setEmail(userDetail.getEmail());
        user.setPassword(encoder.encode(userDetail.getPassword()));
        user.setIsAdmin(userDetail.getIsAdmin());
        user.setIsSeller(userDetail.getIsSeller());

        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    // xóa thông tin khách hàng
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Không có khách hàng có mã: " + id + " !!!"));
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Đã xóa", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}