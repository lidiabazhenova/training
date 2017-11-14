package com.lidiabazhenova;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//import java.util.Iterator;

public class Main {
	
	public static void main(String[] args) {

//		Good milk = new Good("drinks", "milk", 12, 1.5);
//		saveValues(milk);
//		Good apple = new Good("fruits", "apple", 4, 2.2);
//		saveValues(apple);
//		Good orange = new Good("fruits", "orange", 5, 2.3);
//		saveValues(orange);
//		System.out.println(milk.getType());
		
		List<Good> listOfFruits = new LinkedList<>();
        SummaryInformation infoFruits = new SummaryInformation(1,  listOfFruits);
        listOfFruits.add(new Good("fruits", "apple", 4, 1.5));
        listOfFruits.add(new Good("fruits", "orange", 4, 1.5));
        
        List<Good> listOfDrinks = new LinkedList<>();
        SummaryInformation infoDrinks = new SummaryInformation(2,  listOfFruits);
        listOfFruits.add(new Good("fruits", "apple", 4, 1.5));
        listOfFruits.add(new Good("fruits", "orange", 4, 1.5));
        
        
        infoDrinks.printList(listOfDrinks);
	}

	public static void saveValues(Good objectToSave) {
		for (int i = 0; i < objectToSave.write().size(); i++) {
			System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
		}
	}

	public static void loadObject(Good objectToLoad) {
		ArrayList<String> values = readValues();
		objectToLoad.read(values);
	}

	public static ArrayList<String> readValues() {
		ArrayList<String> values = new ArrayList<String>();

		Scanner scanner = new Scanner(System.in);
		boolean quit = false;
		int index = 0;
		System.out.println("Choose\n" + "1 to enter a string\n" + "0 to quit");

		while (!quit) {
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 0:
				quit = true;
				break;
			case 1:
				System.out.print("Enter a string: ");
				String stringInput = scanner.nextLine();
				values.add(index, stringInput);
				index++;
				break;
			}
		}
		return values;
	}

}
