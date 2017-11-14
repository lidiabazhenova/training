package lidiabazhenova.com;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter double number");
		double firstSide = scanner.nextDouble();

		System.out.println("Enter double number");
		double secondSide = scanner.nextDouble();

		System.out.println("Enter double number");
		double thirdSide = scanner.nextDouble();

		try {
			Triangle triangle = new Triangle(firstSide, secondSide, thirdSide);
			System.out.println(triangle.getTypeTriangle());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("enter correct args");
		}

	}
}
