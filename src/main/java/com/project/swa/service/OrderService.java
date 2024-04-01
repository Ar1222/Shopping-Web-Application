package com.project.swa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.swa.Entity.Order;
import com.project.swa.Entity.Transaction;
import com.project.swa.repository.OrderRepository;
import com.project.swa.repository.TransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Method to retrieve orders for a user
    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    // Method to get details of a specific order
    public Optional<Order> getOrderDetails(Long orderId) {
        return orderRepository.findById(orderId);
    }
    @Autowired
    private TransactionRepository transactionRepository;

	public Transaction makePayment(long userId, long orderId, double amount) {
	        Optional<Order> optionalOrder = orderRepository.findById(orderId);
	        if (optionalOrder.isPresent()) {
	            Order order = optionalOrder.get();
	            if (order.getUserId() == userId && amount >= order.getAmount()) {
	                Transaction transaction = new Transaction();
	                transaction.setUserId(userId);
	                transaction.setOrderId(orderId);
	                transaction.setAmount(amount);
	                // Set other transaction details as needed
	                return transactionRepository.save(transaction);
	            }
	        }
	        return null; // Return null if order is not found or payment failed
	    }

	public Order placeOrder(long userId, int qty, String coupon) {
        if (qty < 1|| !isValidCoupon(coupon))  {
            return null;
        }

	        Order order = new Order();
	        order.setUserId(userId);
	        order.setQuantity(qty);
	        order.setCoupon(coupon);
	        // Set other order details as needed
	        return orderRepository.save(order);
	    }

	private boolean isValidCoupon(String coupon) {
		    return true;
	}

	}
