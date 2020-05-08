package com.spicy.kitchen.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "menu")
public class Menu {
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToMany(targetEntity=Item.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "id_fk",referencedColumnName = "id")
    private List<Item> item;
	private transient String message;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Menu(Integer id, List<Item> item, String message) {
		super();
		this.id = id;
		this.item = item;
		this.message = message;
	}
	
	
	
}
