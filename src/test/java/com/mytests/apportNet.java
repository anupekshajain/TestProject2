package com.mytests;


public class apportNet {

	
	public static void main(String args[]) {
		String invoiceNet="800.00";
		String apportionmentNet="200.00";
		verifyAmountToApportionmentPostAddingApportionment(formatNumTonDigitString(Float.valueOf(invoiceNet)-(4*Float.valueOf(apportionmentNet)), 2));
		
	}
	
	private static void verifyAmountToApportionmentPostAddingApportionment(String formatNumTonDigitString) {
		System.out.println(formatNumTonDigitString);
		
	}

	public static String formatNumTonDigitString(Float s,int n) {
		String digitVal ="%."+n+"f";
		return String.format(java.util.Locale.UK, digitVal,s);
	}
}
