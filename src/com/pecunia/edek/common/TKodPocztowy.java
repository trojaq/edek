package com.pecunia.edek.common;

import java.util.Map;

public class TKodPocztowy extends Element {

	public TKodPocztowy(String value, Map<String, String> data ) {
		super("KodPocztowy", value);
		namespace("etd", data);
		// TODO Auto-generated constructor stub
	}

}
