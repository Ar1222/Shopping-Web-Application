package com.project.swa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.swa.Entity.Transaction;
import com.project.swa.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // Method to retrieve transactions by user ID
    public List<Transaction> getTransactionsByUserId(Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    // Method to retrieve transactions by order ID
    public List<Transaction> getTransactionsByOrderId(Long orderId) {
        return transactionRepository.findByOrderId(orderId);
    }
}
