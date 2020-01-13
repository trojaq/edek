package com.pecunia.edek.common;

import java.util.Map;

public class TNrREGON extends Element {

	public TNrREGON(String name, Map<String, String> data) {
		super("REGON", name);
		namespace("etd", data);
	}

	public TNrREGON(String name, Map<String, String> data, boolean etd) {
		super("REGON", name);
		if(etd) namespace("etd", data);
	}

}
