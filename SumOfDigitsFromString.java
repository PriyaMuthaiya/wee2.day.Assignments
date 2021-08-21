package week2.day2.assignments;

import java.util.Iterator;

public class SumOfDigitsFromString {
	
	public static void main(String[] args) {
		 /* Declare a String text with the following value
			String text = "Tes12Le79af65";
		   Declare a int variable sum
			int sum = 0;
		 * a) using replaceAll(), replace all the non-digits into ""
		 * b) Now, convert the String into array
		 * c) Iterate over the array and get each character
		 * d) Using Character.getNumericValue(), Change the char into int
		 * e) Add the values to sum & print
		 * 
		 */
		
		String text="Tes12Le79af65";
		int sum=0;
		
		String replaceAll = text.replaceAll("\\D", "");
		System.out.println(replaceAll);
		
		/*for (int i = 0; i < replaceAll.length(); i++) {
			boolean digit = Character.isDigit(replaceAll.charAt(i));
			if(digit) {
				char charAt = replaceAll.charAt(i);
				int numericValue = Character.getNumericValue(charAt);
				sum=sum+numericValue;
			}*/
			
		char[] rep=replaceAll.toCharArray();
		for (int i = 0; i < rep.length; i++) {
			int val=Character.getNumericValue(rep[i]);
			sum=sum+val;
			
		}
			
			
		
		System.out.println(sum);
		
		/*
		 * Method 2
		 * Pseudo Code
		 * Declare a String text with the following value
			String text = "Tes12Le79af65";
		   Declare a int variable sum
			int sum = 0;
		 * a) Iterate an  array over the String
		 * b) Get each character and check if it is a number using Character.isDigit()
		 * c) Now covert char to int using Character.getNumericValue() and add it to sum
		 * d) Now Print the value
		 */
	}

}
