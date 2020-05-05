package com.capgemini.go.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
		value= {"orderInitiateTime","orderDispatchTime;"},
		allowGetters=true
		)
@Entity
@Table(name="`order`")
public class OrderDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private long orderId;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="user_id",nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private User user;
	@Column(name="product_id")
	private String productID;
	private long addressId;
	@Column(name="order_dispatch_status")
	private boolean orderDispatchStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_initiate_time",nullable=false,updatable=false)
	@CreatedDate
	private Date orderInitiateTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_dispatch_time",nullable=false)
	@LastModifiedDate
	private Date orderDispatchTime;
	
	@Embedded
	private Address address;

	
	public long getOrderId() {
		return orderId;
	}

	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	
	public User getUser() {
		return user;
	}

	
	public void setUser(User user) {
		this.user = user;
	}

	
	public String getProductID() {
		return productID;
	}

	
	public void setProductID(String productID) {
		this.productID = productID;
	}

	
	public long getAddressId() {
		return addressId;
	}

	
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	
	public boolean isOrderDispatchStatus() {
		return orderDispatchStatus;
	}

	
	public void setOrderDispatchStatus(boolean orderDispatchStatus) {
		this.orderDispatchStatus = orderDispatchStatus;
	}

	
	public Date getOrderInitiateTime() {
		return orderInitiateTime;
	}

	
	public void setOrderInitiateTime(Date orderInitiateTime) {
		this.orderInitiateTime = orderInitiateTime;
	}

	
	public Date getOrderDispatchTime() {
		return orderDispatchTime;
	}

	
	public void setOrderDispatchTime(Date orderDispatchTime) {
		this.orderDispatchTime = orderDispatchTime;
	}

	
	public Address getAddress() {
		return address;
	}

	
	public void setAddress(Address address) {
		this.address = address;
	}

	public OrderDTO(long orderId, User user, String productID, long addressId, boolean orderDispatchStatus,
			Date orderInitiateTime, Date orderDispatchTime, Address address) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.productID = productID;
		this.addressId = addressId;
		this.orderDispatchStatus = orderDispatchStatus;
		this.orderInitiateTime = orderInitiateTime;
		this.orderDispatchTime = orderDispatchTime;
		this.address = address;
	}

	public OrderDTO() {
		super();
		
	}

	
}
