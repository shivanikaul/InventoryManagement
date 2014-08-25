package com.ideas.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ideas.model.Item;

@Repository
public class ItemDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addItem(Item item)
	{
		item.setCreatedDttm(new Date());
		item.setLastUpdatedDttm(new Date());
		sessionFactory.getCurrentSession().save(item);
	}
	
	public List<Item> fetchAllItems()
	{
		return sessionFactory.getCurrentSession().createQuery("from Item").list();
	}
	
	public Item findById(Integer id)
	{
		return (Item) sessionFactory.getCurrentSession().get(Item.class,id);
	}

	public void update(Item item)
	{
		item.setLastUpdatedDttm(new Date());
		sessionFactory.getCurrentSession().update(item);
	}
	
	public void delete(Integer id)
	{
		sessionFactory.getCurrentSession().delete(findById(id));
	}

}
 