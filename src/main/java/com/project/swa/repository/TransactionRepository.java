package com.project.swa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.swa.Entity.Transaction;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
    // Find transactions by user ID
    List<Transaction> findByUserId(Long userId);
    
    // Find transactions by order ID
    List<Transaction> findByOrderId(Long orderId);
    
    // Find transactions by user ID and order ID
    Transaction findByUserIdAndOrderId(Long userId, Long orderId);
    
    
}