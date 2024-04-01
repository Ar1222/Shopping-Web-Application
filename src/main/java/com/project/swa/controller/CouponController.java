package com.project.swa.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.swa.service.CouponService;



@RestController
@RequestMapping("/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping
    public ResponseEntity<Map<String, Integer>> fetchCoupons() {
        Map<String, Integer> coupons = couponService.fetchCoupons();
        return ResponseEntity.ok(coupons);
    }
}