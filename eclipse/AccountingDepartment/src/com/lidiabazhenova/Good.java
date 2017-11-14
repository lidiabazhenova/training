package com.lidiabazhenova;

import java.util.ArrayList;
import java.util.List;

public class Good {
	private String type;
	private String name;
	private int quantity;
	private double purchase;

	public Good(String type, String name, int quantity, double price) {
		super();
		this.type = type;
		this.name = name;
		this.quantity = quantity;
		this.purchase = price;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPurchase() {
		return purchase;
	}

	public List<String> write() {
		List<String> values = new ArrayList<String>();
		values.add(0, "" + this.type);
		values.add(1, "" + this.name);
		values.add(2, "" + this.quantity);
		values.add(3, "" + this.purchase);

		return values;
	}

	public void read(List<String> savedGoods) {
	        if (savedGoods != null && savedGoods.size() >0) {
	            this.type = savedGoods.get(0);
	            this.name = savedGoods.get(1);
	            this.quantity = Integer.parseInt(savedGoods.get(2));
	            this.purchase = Double.parseDouble(savedGoods.get(3));
	        }
	
	

}
}
