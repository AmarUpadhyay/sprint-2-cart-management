package com.capgemini.go.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cart_table")
public class CartDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cartItemID;
	public CartDTO(long cartItemID, String product_id, long userID, int quantity) {
		super();
		this.cartItemID = cartItemID;
		this.product_id = product_id;
		this.userID = userID;
		this.quantity = quantity;
	}

	@Column(name="product_id")
	private String product_id;
	
	@Column(name="user_id")
	private long userID;
	
	@Column(name="product_quantity")
	private int quantity;

	public CartDTO() {
		super();
	}

	public long getCartItemID() {
		return cartItemID;
	}

	public void setCartItemID(long cartItemID) {
		this.cartItemID = cartItemID;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

}
