package com.capgemini.go.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class CartKey implements Serializable{
	
	private static final long serialVersionUID = 1L;

/**
	public CartKey() {
		super();
		
	}


	public CartKey(User user, ProductDTO product) {
		super();
		this.user = user;
		this.product = product;
	}


	@OneToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="product_id",nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	
	private ProductDTO product;

	
	public User getUser() {
		return user;
	}

	
	public void setUser(User user) {
		this.user = user;
	}

	
	public ProductDTO getProduct() {
		return product;
	}

	
	public void setProduct(ProductDTO product) {
		this.product = product;
	}**/
	@Column(name="user_id")
	private long userID;
	/**
 * @return the userID
 */
public long getUserID() {
	return userID;
}
/**
 * @param userID the userID to set
 */
public void setUserID(long userID) {
	this.userID = userID;
}
/**
 * @return the productID
 */
public String getProductID() {
	return productID;
}
/**
 * @param productID the productID to set
 */
public void setProductID(String productID) {
	this.productID = productID;
}
/**
 * @return the serialversionuid
 */
	@Column(name="product_id")
	private String productID;
} 
