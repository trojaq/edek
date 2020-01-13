package com.pecunia.edek.common;

import java.util.Map;

public class TJednAdmin extends Element {

	public TJednAdmin(String name, String value, Map<String, String> data) {
		super(name, value);
		namespace("etd", data);
	}

}
