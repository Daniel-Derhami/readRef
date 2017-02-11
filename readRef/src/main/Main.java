/*
 * Main.java
 * Date: Feb 2017
 * Author: Daniel Derhami
 */
package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

		// First if for checking the validation of merchant
		if (Main.isMerchantValid()) {
			switch (corp) {
			case "EU":
				cor = "EUR";
				Main.isStringDouble(cor);
				break;
			case "US":
				cor = "USD";
				Main.isStringDouble(cor);
				break;
			case "SE":
				cor = "SEK";
				Main.isStringDouble(cor);

				break;
			default:
				// Happens when the currency is NOT valid
				System.out.println("Unable to parse " + str + "(currency ‘"
						+ corp + "’ invalid).");
			}
		}
	}

	private static boolean isStringDouble(String cor2) {
		try {
			Double.parseDouble(string2);
			refrenceCheck(cor);
			return true;
		} catch (NumberFormatException ex) {
			// Error message for amount problem
			System.out.println("Unable to parse " + str + " (amount " + string2
					+ " invalid).");
			return false;
		}
	}

	private static boolean refrenceCheck(String cor2) {

		if (fIndex == '0') {
			Pattern p = Pattern.compile("[B,D,I,L,O,Q,S,V]",
					Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(sp);
			boolean b = m.find();
			if (b) {
				System.out.println("Unable to parse " + str + " (reference "
						+ sp + " invalid).");
			} else {
				System.out.println(fp + ","
						+ Main.decode(sp, "123456789ACEFGHJKMNPRTUWXY") + ","
						+ string2 + "," + cor);
			}
		} else if (fIndex == '2') {
			Pattern p2 = Pattern.compile("[B,D,I,L,O,Q,S,U,V]",
					Pattern.CASE_INSENSITIVE);
			Matcher m2 = p2.matcher(sp);
			boolean b2 = m2.find();
			if (b2) {
				System.out.println("Unable to parse " + str + " (reference "
						+ sp + " invalid).");
			} else {
				System.out.println(fp + ","
						+ Main.decode(sp, "234679ACEFGHJKMNPRTWXY") + ","
						+ string2 + "," + cor);
			}
		}
		return false;
	
		
	}

	private static String decode(String sp2, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private static boolean isMerchantValid() {
		if (fp.matches("BOS")) {
			return true;
		} else {
			System.out.println("Unable to parse " + str + "(merchant ‘" + fp
					+ "’ invalid).");
			return false;
		}
	}
	
	
	

}
