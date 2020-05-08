package com.spicy.kitchen.service;


import java.util.List;

import com.spicy.kitchen.model.Menu;

public interface MenuService {
	public Menu createItem(Menu menu);
    public List<Menu> getMenu();
    public Menu findItemById(Integer itemId); 
    public Menu updateItemById(Integer itemId,Menu menu);
    public void deleteItemById(Integer itemId);
}
