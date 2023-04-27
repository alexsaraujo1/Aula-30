package com.t3.onetomanyuni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.t3.onetomanyuni.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
    
}
