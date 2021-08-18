package com.java.backend.repository;

import com.java.backend.model.Brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{
    
}
