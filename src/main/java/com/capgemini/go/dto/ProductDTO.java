package com.capgemini.go.dto;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="product")
public class ProductDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private String productID;
	
	public String getProductID() {
		return productID;
	}

	
	public void setProductID(String productID) {
		this.productID = productID;
	}
	@Column(name="product_price")
	private double price;
	@Column(name="product_colour")
	private String colour;
	@Column(name="product_dimension")
	private String dimension;
	@Column(name="product_specifications")
	private String specifications;
	@Column(name="product_manufacturer")
	private String manufacturer;
	@Column(name="product_quantity")
	private int quantity;
	@Column(name="product_category")
	private String productCategory;
	@Column(name="product_name")
	private String productName;
	
	
	
	
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getColour() {
		return colour;
	}
	
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public String getDimension() {
		return dimension;
	}
	
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	
	public String getSpecifications() {
		return specifications;
	}
	
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getProductCategory() {
		return productCategory;
	}
	
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	@Override
	public String toString() {
		return "ProductDTO [ price=" + price + ", colour=" + colour + ", dimension="
				+ dimension + ", specifications=" + specifications + ", manufacturer=" + manufacturer + ", quantity="
				+ quantity + ", productCategory=" + productCategory + ", productName=" + productName + "]";
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ProductDTO( double price, String colour, String dimension, String specifications,
			String manufacturer, int quantity, String productCategory, String productName) {
		super();
		
		this.price = price;
		this.colour = colour;
		this.dimension = dimension;
		this.specifications = specifications;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.productCategory = productCategory;
		this.productName = productName;
	}
	public ProductDTO() {
		
	}
	
	
	
}
