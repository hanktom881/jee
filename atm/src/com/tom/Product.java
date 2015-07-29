package com.tom;

public class Product {
	int id;
	String name;
	int price;
	String info;
	int stock;
	public Product(){
		
	}
	public Product(int id, String name, int price, String info, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.info = info;
		this.stock = stock;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
