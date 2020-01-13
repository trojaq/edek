package com.pecunia.edek.common;

public class TMiesiac extends Element {

	public TMiesiac(String miesiac) {
		name = "Miesiac";
		setMiesiac(miesiac);
	}

	public void setMiesiac(String miesiac) {
		try {
			int mInt = Integer.parseInt(miesiac.replace(" ", ""));
			if (mInt < 1 || mInt > 12) {
				System.out.println("Niepoprawny miesiac:" + miesiac);
				throw new IllegalArgumentException();
			}
			value = "" + mInt;
		} catch (NumberFormatException ex) {
			System.out.println("Niepoprawny format miesiaca:" + miesiac);
			throw ex;
		}
	}
}
