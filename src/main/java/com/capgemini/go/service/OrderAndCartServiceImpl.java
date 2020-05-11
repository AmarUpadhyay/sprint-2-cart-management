package com.capgemini.go.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.go.dao.OrderAndCartDao;
import com.capgemini.go.dto.Address;
import com.capgemini.go.dto.CartDTO;
import com.capgemini.go.dto.OrderDTO;

@Service
@Transactional
public class OrderAndCartServiceImpl implements OrderAndCartService {
	@Autowired
	private OrderAndCartDao orderAndCartDao;

	@Override
	public boolean addItemToCart(CartDTO cart) {
		
		return orderAndCartDao.addItemToCart(cart);
	}

	

	@Override
	public boolean registerOrder(OrderDTO order) {
		
		return orderAndCartDao.registerOrder(order);
	}

	@Override
	public boolean removeItemFromCart(String productID) {
		
		return orderAndCartDao.removeItemFromCart(productID);
	}

	@Override
	public boolean updateItemQuantity(CartDTO cart) {
	
		return orderAndCartDao.updateItemQuantity(cart);
	}

	

	@Override
	public List<CartDTO> getCartItem(long userID) {
		
		return orderAndCartDao.getCartItem(userID);
	}



	@Override
	public List<OrderDTO> getOrderListByID(long userID) {
		
		return orderAndCartDao.getOrderListByID(userID);
	}



	@Override
	public OrderDTO getOrderDetails(long orderID) {
		
		return orderAndCartDao.getOrderDetails(orderID);
	}



	@Override
	public List<Address> getAddressbyID(long userID) {
		
		return orderAndCartDao.getAddressbyID(userID);
	}
	

	
}
