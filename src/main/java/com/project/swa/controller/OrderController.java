package com.project.swa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.swa.Entity.Order;
import com.project.swa.Entity.Transaction;
import com.project.swa.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{userId}/order")
    public ResponseEntity<?> placeOrder(@PathVariable long userId, @RequestParam int qty, @RequestParam String coupon) {
        Order order = orderService.placeOrder(userId, qty, coupon);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid quantity or coupon");
        }
    }

    @PostMapping("/{userId}/{orderId}/pay")
    public ResponseEntity<?> makePayment(@PathVariable long userId, @PathVariable long orderId, @RequestParam double amount) {
          Transaction transaction = orderService.makePayment(userId, orderId, amount);
        if (transaction !=null) {
            return ResponseEntity.ok(transaction);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment failed");
        }
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable long userId) {
        List<Order> orders = orderService.getUserOrders(userId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{userId}/orders/{orderId}")
    public ResponseEntity<List<Order>> getOrderDetails(@PathVariable long orderId) {
        List<Order> orders = orderService.getUserOrders(orderId);
        return ResponseEntity.ok(orders);
    }
}