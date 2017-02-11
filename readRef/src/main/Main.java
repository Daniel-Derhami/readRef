/*
 * Main.java
 * Date: Feb 2017
 * Author: Daniel Derhami
 */
package main;

import java.util.Scanner;

public class Main {
	static String fp;
	static String string1;
	static String string2;
	static String str;
	static String sp;
	static String corp;
	static char fIndex;
	static String cor;

	public static void main(String[] args) {

		System.out.println("Enter a String: ");
		Scanner scan = new Scanner(System.in);
		str = scan.nextLine();
		// split input into 2 parts
		String[] parts = str.split(",", 2);
		// Part one contains : payment receiver, currency and encoded reference
		string1 = parts[0];
		// Part two contains the payment amount
		string2 = parts[1];
		// Separate payment receiver
		fp = string1.substring(0, 3);
		// Separate currency part
		corp = string1.substring(3, 5);
		// keep the rest as encoded reference
		sp = string1.substring(5, string1.length());
		fIndex = sp.charAt(0);
		// For saving the currency : EUR, USD or SEK
		String cor = new String();
	}

}
