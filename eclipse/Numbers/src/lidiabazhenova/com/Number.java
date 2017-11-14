package lidiabazhenova.com;

import java.util.Scanner;

public class Number {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter int number");
		String myStrNumber = sc.nextLine();

		char[] chars = myStrNumber.toCharArray();

		for (int i = 0; i < chars.length - 1; i++) {

			//System.out.println(chars[i]);
			if ((chars[i] < chars[i + 1])) {
				if (i + 1 == chars.length - 1) {
					System.out.println("upper numbers");
				}
			} else if (i + 1 == chars.length - 1){
				System.out.println("Noupper numbers");
			}

		}

	}

}
