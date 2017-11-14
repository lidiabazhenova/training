package com.lidiabazhenova;

import java.util.ArrayList;
import java.util.HashSet;

public class Good {
	private String type;
	private String name;
	private int quantity;
	private double price;

	public Good(String type, String name, int quantity, double price) {
		super();
		this.type = type;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
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
	
		public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Good [type=" + type + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}

	public static int getQuantityOfType(ArrayList<Good> goods) {
		HashSet<String> setOfTypes = new HashSet<>(); 
		
		int quantityOfTypes=0;
		
		for (Good good : goods) {
			setOfTypes.add(good.getType());
				}
		quantityOfTypes=setOfTypes.size();
		return quantityOfTypes;
	}
	
	public static int getQuantityOfAllGoods(ArrayList<Good> goods) {
		int quantityOfAllGoods=0;
		for (Good good : goods) {
			quantityOfAllGoods = quantityOfAllGoods + good.getQuantity();
				}
		return quantityOfAllGoods;
	}
	
	
	
	public static double getAveragePrice(ArrayList<Good> goods) {
		double sumPrice = 0;
		double avaragePrice = 0;
		for (Good good : goods) {
			sumPrice = sumPrice + good.getPrice();
			avaragePrice = sumPrice / goods.size();

		}
		return avaragePrice;
	}

}
