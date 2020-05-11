package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.dao.OrderAndCartDao;
import com.capgemini.go.dto.Address;
import com.capgemini.go.dto.CartDTO;
import com.capgemini.go.dto.OrderDTO;
;

public interface OrderAndCartService extends OrderAndCartDao {
	
	public boolean addItemToCart(CartDTO cart);
	public List<OrderDTO> getOrderListByID(long userID);
	public boolean registerOrder(OrderDTO order);
	public boolean removeItemFromCart(String productID);
	public boolean updateItemQuantity(CartDTO cart);
	public OrderDTO getOrderDetails(long orderID);
	public List<CartDTO> getCartItem(long userID);
	public List<Address> getAddressbyID(long userID);



}
