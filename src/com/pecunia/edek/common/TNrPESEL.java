package com.pecunia.edek.common;

import java.util.Map;

public class TNrPESEL extends Element {

	public TNrPESEL(String name, Map<String, String> data) {
		this(name, data, true);
	
	}

	public TNrPESEL(String name, Map<String, String> data, boolean etd) {
		super("PESEL", name);
		if(etd) namespace("etd", data);
	
	}


}
