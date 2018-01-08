package com.dounine.crud.entity;

import com.dounine.crud.enums.FruitType;

public class Fruit {
	
	private String id;
	
	private String name;
	
	private Double price;
	
	private FruitType fruitType;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public FruitType getFruitType() {
		return fruitType;
	}

	public void setFruitType(FruitType fruitType) {
		this.fruitType = fruitType;
	}
	
	
	
	

}
