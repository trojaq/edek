package com.pecunia.edek.common;

public class TKwartal extends Element {

	public TKwartal(String kwart) {
		name = "Kwartal";
		setKwartal(kwart);
	}

	public void setKwartal(String kwart) {
		try {
			int kwartInt = Integer.parseInt(kwart.replace(" ", ""));
			if (kwartInt < 1 || kwartInt > 4) {
				System.out.println("Niepoprawny kwartal:" + kwart);
				throw new IllegalArgumentException();
			}

			value = "" + kwartInt;
		} catch (NumberFormatException ex) {
			System.out.println("Niepoprawny format kwartalu:" + kwart);
			throw ex;
		}
	}
}
