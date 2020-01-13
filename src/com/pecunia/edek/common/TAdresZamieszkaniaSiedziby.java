package com.pecunia.edek.common;

import java.util.Map;

public class TAdresZamieszkaniaSiedziby extends TAdres {

	public TAdresZamieszkaniaSiedziby() {
		super("AdresZamieszkaniaSiedziby");
		//to remove etd: namespace
		name = "AdresZamieszkaniaSiedziby";
		getAttributes().put("rodzajAdresu", "RAD");
	}

	public TAdresZamieszkaniaSiedziby(Map<String, String> data) {
		super("AdresZamieszkaniaSiedziby", data, "");
		//to remove etd: namespace
		name = "AdresZamieszkaniaSiedziby";
		getAttributes().put("rodzajAdresu", "RAD");
	}

}
