package com.capgemini.go.controller;

import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.go.dto.Address;
import com.capgemini.go.dto.CartDTO;
import com.capgemini.go.dto.OrderDTO;
import com.capgemini.go.exception.OrderNotFoundException;
import com.capgemini.go.exception.ProductNotFoundException;
import com.capgemini.go.service.OrderAndCartService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api/cart-management")
public class OrderController {
	
		private static final Logger log=LoggerFactory.getLogger(OrderController.class);
	
		@Autowired
		private OrderAndCartService orderAndCartService;
		
		@GetMapping("cart-item/{user_id}")
		@HystrixCommand(fallbackMethod="getFallBackCart")
		public List<CartDTO> getCartItem(@PathVariable("user_id") long userID) throws ProductNotFoundException{
			
			log.info("Fetching Item from Cart...");
			return orderAndCartService.getCartItem(userID);
		}
		public List<CartDTO> getFallBackCart(@PathVariable("user_id") long userID){
			return Arrays.asList(new CartDTO(0,"No Product in Cart",0,0));
		}
		
		@PostMapping("addItemToCart")
		public String addItemToCart(@RequestBody CartDTO cart) throws IllegalArgumentException{
			
			log.info("Adding Item to Cart...");
			boolean status=orderAndCartService.addItemToCart(cart);
			if(!status)
			{
				throw new IllegalArgumentException();
			}
			return "Item added to cart!!";

		}
		
		@DeleteMapping("remove-item/{product_id}")
		public String removeItemFromCart(@PathVariable("product_id") String productID) throws ProductNotFoundException{
			
			log.info("Removing Item from Cart...");
			boolean status=orderAndCartService.removeItemFromCart(productID);
			if(!status)
			{
				throw new ProductNotFoundException("Product is not available with this is id:"+productID);
			}
			return "Item deleted from cart!!";
		}
		
		@PostMapping("update-quantity/{product_id}")
		public String updateItemQuantity(@RequestBody CartDTO cart,@PathVariable("product_id") String productID) throws ProductNotFoundException{
		
			cart.setProduct_id(productID);
			log.info("Updtaing Product Details ...");
			boolean status=orderAndCartService.updateItemQuantity(cart);
			if(!status)
			{
				throw new ProductNotFoundException("Product is not available with this is id:"+productID);
			}
			return "Quantity updated!!";
		}
		
		@GetMapping("order-list/{user_id}")
		@HystrixCommand(fallbackMethod="getFallBackOrder")
		public List<OrderDTO> getOrderListByID(@PathVariable("user_id") long userID) throws OrderNotFoundException
		{
			log.info("Fetching the order list...");
			List<OrderDTO> orders=orderAndCartService.getOrderListByID(userID);
			if(orders.isEmpty())
			{
				throw new OrderNotFoundException("No Order Available For User ID:"+userID);
			}
			
			return orders;
		}
		public List<OrderDTO> getFallBackOrder(@PathVariable("user_id") long userID){
			return Arrays.asList(new OrderDTO(0,null,"No Order Available",0,false,
					null,null,0,0,null,null,null,null));
		}
		
		@GetMapping("order-details/{order_id}")
		public OrderDTO getOrderDetails(@PathVariable("order_id") long orderID) throws OrderNotFoundException
		{
			log.info("Fetching the order details...");
			OrderDTO orderDetails=orderAndCartService.getOrderDetails(orderID);
			if(orderDetails==null)
			{
				throw new OrderNotFoundException("No Order is available with the order id:"+orderID);
			}
			return orderDetails;
		}
		
		@PostMapping("register-order")
		public boolean registerOrder(@RequestBody OrderDTO order)  
		{
			log.info("Registering the order details...");
			boolean status=orderAndCartService.registerOrder(order);
		    return status; 
			
			
		}
		
		@GetMapping("address-list/{user_id}")
		public List<Address> getAddressByID(@PathVariable("user_id") long userID){
			log.info("Fetching the list of Address...");
			return orderAndCartService.getAddressbyID(userID);
		}
		
}
