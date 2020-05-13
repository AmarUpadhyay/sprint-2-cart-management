package com.capgemini.go.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
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
	@Column(name="order_dispatch_time")
	@LastModifiedDate
	private Date orderDispatchTime;
	
	@Column(name="houseNO")
	private int houseNumber;
	@Column(name="buildingNO")
	private int buildingNumber;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="field")
	private String landmark;
	@Column(name="zip")
	private String zip;

	
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

	
	

	
	
	public int getHouseNumber() {
		return houseNumber;
	}


	
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}


	
	public int getBuildingNumber() {
		return buildingNumber;
	}


	
	public void setBuildingNumber(int buildingNumber) {
		this.buildingNumber = buildingNumber;
	}


	
	public String getCity() {
		return city;
	}


	
	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	
	public void setState(String state) {
		this.state = state;
	}


	
	public String getLandmark() {
		return landmark;
	}


	
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}


	
	public String getZip() {
		return zip;
	}


	
	public OrderDTO(long orderId, User user, String productID, long addressId, boolean orderDispatchStatus,
			Date orderInitiateTime, Date orderDispatchTime, int houseNumber, int buildingNumber, String city,
			String state, String landmark, String zip) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.productID = productID;
		this.addressId = addressId;
		this.orderDispatchStatus = orderDispatchStatus;
		this.orderInitiateTime = orderInitiateTime;
		this.orderDispatchTime = orderDispatchTime;
		this.houseNumber = houseNumber;
		this.buildingNumber = buildingNumber;
		this.city = city;
		this.state = state;
		this.landmark = landmark;
		this.zip = zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public OrderDTO() {
		super();
		
	}

	
}
