package com.project.swa.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public int getOrderedQuantity() {
		return orderedQuantity;
	}

	public void setOrderedQuantity(int orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	private int availableQuantity;

    private int orderedQuantity;

    private double price;
    private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}

}