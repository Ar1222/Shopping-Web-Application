package com.project.swa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.swa.Entity.Inventory;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    
    // Find all inventory items with available quantity greater than 0
    List<Inventory> findByAvailableQuantityGreaterThan(int quantity);
    
    // Find all inventory items with available quantity less than or equal to a specified quantity
    List<Inventory> findByAvailableQuantityLessThanOrEqual(int quantity);
    
    // Find all inventory items with ordered quantity greater than 0
    List<Inventory> findByOrderedQuantityGreaterThan(int quantity);
    
    // Find all inventory items with ordered quantity less than or equal to a specified quantity
    List<Inventory> findByOrderedQuantityLessThanOrEqual(int quantity);
    
    // Find inventory item by price
    List<Inventory> findByPrice(double price);
    
    
}