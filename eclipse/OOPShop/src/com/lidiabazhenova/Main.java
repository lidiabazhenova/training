package com.lidiabazhenova;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Good> goods = new ArrayList<>();
		ArrayList<Good> fruits = new ArrayList<>();
		ArrayList<Good> drinks = new ArrayList<>();

		String exit = "";
		while (!exit.equals("info")) {

			Good good = scannerGoods();
			String typeOfGood = good.getType();
			switch (typeOfGood) {
			case "fruit":
				fruits.add(good);
				goods.add(good);
				break;
			case "drink":
				drinks.add(good);
				goods.add(good);
				break;

			}

			System.out.println("Enter 'info' for information;\n" + " 'c' for continue to add items");
			exit = scanner.next();

		}

		System.out.println("Quantity of all types of goods " + Good.getQuantityOfType(goods));
		System.out.println("Quantity of goods " + Good.getQuantityOfAllGoods(goods));
		System.out.println("Average price of goods " + Good.getAveragePrice(goods));
		System.out.println("Average price of fruits " + Good.getAveragePrice(fruits));
		System.out.println("Average price of drinks " + Good.getAveragePrice(drinks));

		// for (Good good : goods) {
		// System.out.println("print goods");}
		// System.out.println("print fruits");
		// for (Good fruit : fruits) {
		// System.out.println(fruit);}
		// System.out.println("print drinks");
		// for (Good drink : drinks) {
		// System.out.println(drink);}

	}

	public static Good scannerGoods() {
		String type;
		String name;
		String quantity;
		String price;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter type of good(fruit, drink)");
		type = scanner.next();
		System.out.println("Enter name of good");
		name = scanner.next();
		System.out.println("Enter quantity of good");
		quantity = scanner.next();
		System.out.println("Enter price of good");
		price = scanner.next();

		Good good = new Good(type, name, Integer.parseInt(quantity), Double.parseDouble(price));

		return good;
	}

}
