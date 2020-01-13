package com.pecunia.edek.common;

import java.util.Map;

public class TNrBudynku extends Element {

	public TNrBudynku(String name, String value, Map<String, String> data) {
		super(name, value);
		namespace("etd", data);
	}

}
