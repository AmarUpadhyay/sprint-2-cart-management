package com.capgemini.go.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private long userID;
	public User() {
		super();
		
	}

	@Column(name="user_type")
	private String userType;
	@Column(name="user_name")
	private String userName;
	@Column(name="user_password")
	private String userPassword;
	@Column(name="user_email")
	private String userEmail;
	@Column(name="user_phone")
	private long userPhone;
	@Column(name="flag")
	private byte flag;
	
	

	public User(long userID, String userType, String userName, String userPassword, String userEmail, long userPhone,
			byte flag, CartKey cartKey) {
		super();
		this.userID = userID;
		this.userType = userType;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.flag = flag;
		//this.cartKey = cartKey;
	}

	/**@OneToOne(fetch=FetchType.LAZY,mappedBy="user",cascade=CascadeType.ALL)
	private CartKey cartKey;
	**/
		public long getUserID() {
		return userID;
	}

	
	public void setUserID(long userID) {
		this.userID = userID;
	}

	
	public String getUserType() {
		return userType;
	}

	
	public void setUserType(String userType) {
		this.userType = userType;
	}

	
	public String getUserName() {
		return userName;
	}

	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getUserPassword() {
		return userPassword;
	}

	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	
	public String getUserEmail() {
		return userEmail;
	}

	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	
	public long getUserPhone() {
		return userPhone;
	}

	
	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	
	public byte getFlag() {
		return flag;
	}

	
	public void setFlag(byte flag) {
		this.flag = flag;
	}


	
	/*
	 * public CartKey getCartKey() { return cartKey; }
	 */


	
	/*
	 * public void setCartKey(CartKey cartKey) { this.cartKey = cartKey; }
	 */

	
	
	
}
