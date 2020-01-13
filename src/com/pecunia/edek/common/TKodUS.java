package com.pecunia.edek.common;

public class TKodUS extends Element {

	public TKodUS(String kod) {
		name = "KodUrzedu";
		setKod(kod);
	}

	private void setKod(String kod) {
		if (kod.length() != 4) {
			throw new IllegalArgumentException("Kod US powinien miec 4 cyfry");
		}
		value = kod;
	}

}
