package com.project.swa.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.swa.service.InventoryService;


@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<Map<String, Integer>> getInventoryStatus() {
        Map<String, Integer> inventoryStatus = inventoryService.getInventoryStatus();
        return ResponseEntity.ok(inventoryStatus);
    }
}