package com.pecunia.edek.common;

import java.util.Map;

public class TNazwisko extends Element {

	public TNazwisko(String name, Map<String, String> data) {
		super("Nazwisko", name);
		namespace("etd", data);
		// TODO Auto-generated constructor stub
	}

	public TNazwisko(String name, Map<String, String> data, boolean etd) {
		super("Nazwisko", name);
		if(etd) namespace("etd", data);
		// TODO Auto-generated constructor stub
	}
}
