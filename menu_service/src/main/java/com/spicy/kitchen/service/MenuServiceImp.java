package com.spicy.kitchen.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spicy.kitchen.dao.MenuRepository;
import com.spicy.kitchen.model.Menu;

@Service

public class MenuServiceImp implements MenuService {
	@Autowired
	private MenuRepository menuRepository;


	@Override
	public Menu createItem(Menu menu) {
		
		return menuRepository.save(menu);
	}

	@Override
	
	public List<Menu> getMenu() {
		// TODO Auto-generated method stub
		return menuRepository.findAll();
	}
	

	@Override
	public Menu findItemById(Integer itemId) {
		// TODO Auto-generated method stub
		return menuRepository.findById(itemId).get();
	}

	@Override
	public Menu updateItemById(Integer itemId, Menu menu) {
		return menuRepository.save(menu);

	}

	@Override
	public void deleteItemById(Integer itemId) {
		menuRepository.deleteById(itemId);

	}
}
