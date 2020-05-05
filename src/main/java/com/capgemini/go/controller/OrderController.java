package com.capgemini.go.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.dto.CartDTO;
import com.capgemini.go.dto.OrderDTO;
import com.capgemini.go.exception.ProductException;
import com.capgemini.go.service.OrderAndCartService;
@RestController
@RequestMapping(value="/cart-management")
public class OrderController {
	
		@Autowired
		private OrderAndCartService orderAndCartService;
		
		@GetMapping("cart-item/{user_id}")
		public List<CartDTO> getCartItem(@PathVariable("user_id") long userID) throws ProductException
		{
			
			return orderAndCartService.getCartItem(userID);
		}
		
		@PostMapping("addItemToCart")
		public String addItemToCart(@RequestBody CartDTO cart) throws ProductException
		{
			boolean status=orderAndCartService.addItemToCart(cart);
			if(!status)
			{
				throw new ProductException();
			}
			return "Item added to cart!!";

		}
		
		@DeleteMapping("remove-item/{product_id}")
		public String removeItemFromCart(@PathVariable("product_id") String productID) throws ProductException

		{
			
			boolean status=orderAndCartService.removeItemFromCart(productID);
			if(!status)
			{
				throw new ProductException();
			}
			return "Item deleted from cart!!";
		}
		
		@PostMapping("update-quantity/{product_id}")
		public String updateItemQuantity(@RequestBody CartDTO cart,@PathVariable("product_id") String productID) throws ProductException
		{
			cart.getCartKey().setProductID(productID);
			boolean status=orderAndCartService.updateItemQuantity(cart);
			if(!status)
			{
				throw new ProductException();
			}
			return "Quantity updated!!";
		}
		
		@GetMapping("order-list/{user_id}")
		public List<OrderDTO> getOrderListByID(@PathVariable("user_id") long userID) throws ProductException
		{
			return orderAndCartService.getOrderListByID(userID);
		}
		
		@GetMapping("order-details/{order_id}")
		public OrderDTO getOrderDetails(@PathVariable("order_id") long orderID) throws ProductException
		{
			return orderAndCartService.getOrderDetails(orderID);
		}
		
		@PostMapping("register-order")
		public String registerOrder(@RequestBody OrderDTO order) throws ProductException
		{
			if(!orderAndCartService.registerOrder(order))
			{
			   throw new ProductException();
			}
			return "Order Placed Congratulations!!";
		}
}
