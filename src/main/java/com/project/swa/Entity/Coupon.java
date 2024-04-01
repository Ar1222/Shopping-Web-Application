package com.project.swa.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	private String code;

    private int discountPercentage;

}