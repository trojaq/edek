package com.pecunia.edek.common;

import java.util.Map;

public class TNrNIP extends Element {

	public TNrNIP(String name, Map<String, String> data) {
		super("NIP", name);
		namespace("etd", data);
	}

	public TNrNIP(String name, Map<String, String> data, boolean etd) {
		super("NIP", name);
		if(etd) namespace("etd", data);
	}
}
