package com.ideas.model;

public enum ItemType {
	Grocery("0"),
	Electronics("1"),
	HomeDecor("2"),
	Cutlery("3"),
	Stationary("4");
	
	private String type;
	ItemType(String type)
	{
		this.type = type;
	}
	public ItemType getType(String type)
	{
		return ItemType.valueOf(type);
	}
	
	

}
