package com.ideas.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas.dao.ItemDao;
import com.ideas.dao.PurchaseHistoryDao;
import com.ideas.model.Item;
import com.ideas.model.PurchaseHistory;

@Service
@Transactional
public class PurchaseService {

	@Autowired
	private PurchaseHistoryDao purchaseHistoryDao;
	
	public void add(Item item)
	{
		purchaseHistoryDao.addPurchaseHistory(item);

	}	

	public List<PurchaseHistory> fetchPurchaseHistory(Integer itemId)
	{
		return purchaseHistoryDao.fetchByItemId(itemId);
	}
}
