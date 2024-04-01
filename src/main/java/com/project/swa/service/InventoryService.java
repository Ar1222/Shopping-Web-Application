package com.project.swa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.swa.Entity.Inventory;
import com.project.swa.repository.InventoryRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    // Method to get inventory status
    public Map<String, Integer> getInventoryStatus() {
        // Retrieve all inventory items from the repository
        List<Inventory> inventoryItems = inventoryRepository.findAll();

        // Initialize a map to store inventory status
        Map<String, Integer> inventoryStatus = new HashMap<>();

        // Iterate through the inventory items and populate the status map
        for (Inventory item : inventoryItems) {
            inventoryStatus.put(item.getName(), item.getAvailableQuantity());
        }

        return inventoryStatus;
    }

}