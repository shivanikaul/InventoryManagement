package com.ideas.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ideas.model.Item;
import com.ideas.model.PurchaseHistory;

@Repository
public class PurchaseHistoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addPurchaseHistory(Item item)
	{
		PurchaseHistory purchaseHistory = new PurchaseHistory();
		purchaseHistory.setPurchasedOn(new Date());
		purchaseHistory.setItemId(item.getId());
		purchaseHistory.setPrice(item.getQuantity() * item.getPrice());
		purchaseHistory.setQuantity(item.getQuantity());
		sessionFactory.getCurrentSession().save(purchaseHistory);
	}
	
	public List<PurchaseHistory> fetchByItemId(Integer itemId)
	{
		return sessionFactory.getCurrentSession().createQuery("from PurchaseHistory where itemId = :id").
				setParameter("id", itemId).list();
	}
	
	
	
}
