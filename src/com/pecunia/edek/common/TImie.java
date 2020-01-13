package com.pecunia.edek.common;

import java.util.Map;

public class TImie extends Element {

	public TImie(String name, String value, Map<String, String> data) {
		super(name, value);
		namespace("etd", data);
	}

	public TImie(String name, String value, Map<String, String> data, boolean etd) {
		super(name, value);
		if(etd) namespace("etd", data);
	}

}
