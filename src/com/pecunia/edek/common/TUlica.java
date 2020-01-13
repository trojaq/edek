package com.pecunia.edek.common;

import java.util.Map;

public class TUlica extends Element {

	public TUlica(String name, Map<String, String> data) {
		super("Ulica", name);
		namespace("etd", data);
	}

}
