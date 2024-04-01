package com.project.swa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.swa.Entity.Coupon;
import com.project.swa.repository.CouponRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    // Method to fetch all coupons
    public Map<String, Integer> fetchCoupons() {
        // Fetch all coupons from the repository
        List<Coupon> coupons = couponRepository.findAll();
     // Convert the list of coupons to a map of coupon codes and discount percentages
        // Assuming coupon code is unique
        return coupons.stream()
                .collect(Collectors.toMap(Coupon::getCode, Coupon::getDiscountPercentage));
    }
}
        