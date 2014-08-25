package com.ideas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideas.model.Item;
import com.ideas.service.ItemService;
import com.ideas.service.PurchaseService;


@Controller
public class MainController {

	@Autowired
	private ItemService itemService;
	@Autowired
	private PurchaseService purchaseService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView mainPage()
	{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ModelAndView homePage()
	{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/addItemsToPage",method=RequestMethod.GET)
	public ModelAndView addItemsPage(){		
		ModelAndView modelAndView = new ModelAndView("add-items-page");
		modelAndView.addObject("item",new Item());
		return modelAndView;
	}
	
	@RequestMapping(value="/addItems", method=RequestMethod.POST)
	public ModelAndView addItem(@ModelAttribute Item item) {		
		ModelAndView modelAndView = new ModelAndView("list-of-items");
		itemService.add(item);		
		String message = "Item was successfully added.";
		modelAndView.addObject("message", message);
		modelAndView.addObject("items",itemService.findAll());
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/listOfItems")
	public ModelAndView listOfItems(){		
		ModelAndView modelAndView = new ModelAndView("list-of-items");
		modelAndView.addObject("items",itemService.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-item-form");
		Item item = itemService.getItem(id);
		modelAndView.addObject("item",item);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView editItem(@ModelAttribute Item item, @PathVariable Integer id) {		
		ModelAndView modelAndView = new ModelAndView("list-of-items");		
		itemService.update(item);		
		String message = "Item was successfully edited.";
		modelAndView.addObject("message", message);
		modelAndView.addObject("items",itemService.findAll());
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteItem(@PathVariable Integer id) {		
		ModelAndView modelAndView = new ModelAndView("list-of-items");		
		itemService.delete(id);		
		String message = "Item was successfully purchased.";
		modelAndView.addObject("message", message);
		modelAndView.addObject("items",itemService.findAll());
		
		return modelAndView;
	}
	

	@RequestMapping(value="/purchaseItem/{id}", method=RequestMethod.POST)
	public ModelAndView purchaseItem(@ModelAttribute Item item, @PathVariable Integer id) {		
		ModelAndView modelAndView = new ModelAndView("list-of-purchase-history");		
		purchaseService.add(itemService.getItem(id));		
		String message = " Item was successfully PURCHASED.";
		modelAndView.addObject("message", message);
		modelAndView.addObject("purchaseHistories",purchaseService.fetchPurchaseHistory(item.getId()));
		modelAndView.addObject("item",itemService.getItem(item.getId()));		
		return modelAndView;
	}
	
	@RequestMapping(value="/purchaseItem/{id}", method=RequestMethod.GET)
	public ModelAndView purchaseItemPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("purchase-item-page");
		Item item = itemService.getItem(id);
		modelAndView.addObject("item",item);
		return modelAndView;
	}
	
	
}
