package com.spicy.kitchen.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spicy.kitchen.exception.ErrorMessage;
import com.spicy.kitchen.exception.IdNotFoundException;
import com.spicy.kitchen.model.Menu;
import com.spicy.kitchen.service.MenuService;

@RestController
@RequestMapping("/api")
public class MenuController  {
	  static Logger logger = LogManager.getLogger(MenuController.class);

	private MenuService menuService;

	@Autowired
	public MenuController(MenuService menuService) {
		super();
		this.menuService = menuService;
	}

	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handleError1(IdNotFoundException infe) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessage(infe.getMessage());
		errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
		errorMessage.setErrorTime(LocalDateTime.now());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handleError2(Exception e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessage(e.getMessage());
		errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
		errorMessage.setErrorTime(LocalDateTime.now());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/spicykitchen/menu")
	public Menu createMenu(@RequestBody Menu menu) {
		// TODO Auto-generated method stub
		return menuService.createItem(menu);

	}

	
	@GetMapping("/spicykitchen/menu")
	public List<Menu> getMenu(@RequestHeader(value = "TXN_ID") String txnId) {
		  //ConsoleHandler handler  = new ConsoleHandler(); 
	   //  logger.addHandler(handler); 
		logger.error("transaction id" +txnId+ "|" + "error occuried");
	    logger.trace("getMenu method Accessed" + txnId);
		 
		return menuService.getMenu();

	}
	
	

	@GetMapping("/spicykitchen/{itemId}/menu")
	public Menu findItemById(@PathVariable Integer itemId) {
		if (menuService.findItemById(itemId) == null)

		{
			throw new IdNotFoundException("The id is not found : " + itemId);
		} else
			return menuService.findItemById(itemId);
	}

	@PutMapping("/spicykitchen/{itemId}/menu")
	public void updateItemById(@PathVariable Integer itemId, @RequestBody Menu menu) {
		if (menuService.updateItemById(itemId, menu) == null)

		{
			throw new IdNotFoundException("The id is not found : " + itemId);
		} else
			menuService.updateItemById(itemId, menu);

	}

	@DeleteMapping("/spicykitchen/{itemId}/menu")
	public void deleteItemById(@PathVariable Integer itemId) {

		menuService.deleteItemById(itemId);

	}
}
