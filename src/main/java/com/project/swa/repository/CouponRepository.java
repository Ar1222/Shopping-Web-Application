package com.project.swa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.swa.Entity.Coupon;

import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    
    // Find coupon by code
    Optional<Coupon> findByCode(String code);
    
    // Find coupon by discount percentage
    Optional<Coupon> findByDiscountPercentage(int discountPercentage);
    
    
}