package com.capgemini.go.dao;

import java.util.List;

import com.capgemini.go.dto.CartDTO;
import com.capgemini.go.dto.OrderDTO;

public interface OrderAndCartDao {
	public boolean addItemToCart(CartDTO cart);
	public List<OrderDTO> getOrderListByID(long userID);
	public boolean registerOrder(OrderDTO order);
	public boolean removeItemFromCart(String productID);
	public boolean updateItemQuantity(CartDTO cart);
	public OrderDTO getOrderDetails(long orderID);
	public List<CartDTO> getCartItem(long userID);


}
