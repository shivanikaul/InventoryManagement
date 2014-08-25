package com.ideas.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.ideas.dao.ItemDao;
import com.ideas.model.Item;


@Service
@Transactional
public class ItemService {
	
	@Autowired
	private ItemDao itemDao;
	
	public boolean add(Item item)
	{
		itemDao.addItem(item);
		return true;
	}
	
	public List<Item> findAll()
	{
		return itemDao.fetchAllItems();
	}
	
	
	public Item getItem(Integer id)
	{
		return itemDao.findById(id);
	}
	
	public void update(Item item)
	{
		itemDao.update(item);
	}
	
	
	public void delete(Integer itemId)
	{
		itemDao.delete(itemId);
	}

}
