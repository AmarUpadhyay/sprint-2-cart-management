package com.capgemini.go.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.go.dto.Address;
import com.capgemini.go.dto.CartDTO;
import com.capgemini.go.dto.OrderDTO;

@Repository
public class OrderAndCartDaoImpl implements OrderAndCartDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addItemToCart(CartDTO cartItem) {
		boolean status;
		sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
		status=true;
		return status;
	}

	

	

	@Override
	public boolean registerOrder(OrderDTO order) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(order);
			status=true;
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean removeItemFromCart(String productID) {
		boolean status=false;
		Session currentSession=sessionFactory.getCurrentSession();
		Query<CartDTO> query=currentSession.createQuery("from CartDTO where product_id=:product_id",CartDTO.class);
		query.setParameter("product_id", productID);
		CartDTO cart=query.getSingleResult();
		currentSession.delete(cart);
		status=true;
		return status;
	}

	@Override
	public boolean updateItemQuantity(CartDTO cart) {
		boolean status=false;
		sessionFactory.getCurrentSession().update(cart);
		status=true;
		return status;
	}

	
	@Override
	public List<CartDTO> getCartItem(long userID) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<CartDTO> query=currentSession.createQuery("from CartDTO where user_id=:user_id",CartDTO.class);
		query.setParameter("user_id", userID);
		return query.getResultList();
	}





	@Override
	public List<OrderDTO> getOrderListByID(long userID) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<OrderDTO> query=currentSession.createQuery("from OrderDTO where user_id=:user_id",OrderDTO.class);
		query.setParameter("user_id",userID);
		return query.getResultList();
	}





	@Override
	public OrderDTO getOrderDetails( long orderID) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<OrderDTO> query=currentSession.createQuery("from OrderDTO where order_id=:order_id",OrderDTO.class);
		query.setParameter("order_id",orderID);
		return query.getSingleResult();
	}





	@Override
	public List<Address> getAddressbyID(long userID) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Address> query=currentSession.createQuery("from Address where user_id=:user_id",Address.class);
		query.setParameter("user_id",userID);
		return query.getResultList();
		
	}

	
	
	
	
}
