package com.ideas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="purchasehistory")
public class PurchaseHistory {

	@Id
	@GeneratedValue
	private int id;
	private int itemId;
	private int quantity;
	private double price;
	private Date purchasedOn;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Date getPurchasedOn() {
		return purchasedOn;
	}
	public void setPurchasedOn(Date purchasedOn) {
		this.purchasedOn = purchasedOn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
