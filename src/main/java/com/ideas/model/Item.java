package com.ideas.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="item")
public class Item implements Serializable {

	private static final long serialVersionUID = -372622162318919181L;

	public static final String ALL= "com.ideas.model.Item.ALL";

	@Id
	@GeneratedValue
	
	private int id;
	private String name;
	private String description;
	private int quantity;
	private double price;
	private Date createdDttm;
	private Date lastUpdatedDttm;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getCreatedDttm() {
		return createdDttm;
	}
	public void setCreatedDttm(Date createdDttm) {
		this.createdDttm = createdDttm;
	}
	public Date getLastUpdatedDttm() {
		return lastUpdatedDttm;
	}
	public void setLastUpdatedDttm(Date lastUpdatedDttm) {
		this.lastUpdatedDttm = lastUpdatedDttm;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
