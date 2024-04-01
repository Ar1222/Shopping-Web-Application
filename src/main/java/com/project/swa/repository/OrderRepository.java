package com.project.swa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.swa.Entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
    // Find orders by user ID
    List<Order> findByUserId(Long userId);
    
    // Find orders by user ID and order ID
    Order findByUserIdAndId(Long userId, Long orderId);
    
    
}