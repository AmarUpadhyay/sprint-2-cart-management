package com.capgemini.go.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;


@Entity
@Table(name="cart_table")
public class CartDTO {
	
	@EmbeddedId
	private CartKey cartKey;
	
	@Column(name="product_quantity")
	private int quantity;

	public CartDTO() {
		super();
	}

	
	public CartKey getCartKey() {
		return cartKey;
	}

	
	public void setCartKey(CartKey cartKey) {
		this.cartKey = cartKey;
	}

	
	public int getQuantity() {
		return quantity;
	}

	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

}
