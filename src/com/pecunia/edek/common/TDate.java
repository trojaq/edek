package com.pecunia.edek.common;

import java.util.Map;

public class TDate extends Element {

	public TDate(int rok, int miesiac, int dzien, Map<String, String> data) {
		this("Data", rok, miesiac, dzien, data);
	}

	public TDate(String name, String value, Map<String, String> data) {
		super(name, value);
		namespace("etd", data);
	}

	public TDate(String name, String value, Map<String, String> data, boolean etd) {
		super(name, value);
		if(etd) namespace("etd", data);
	}

	public TDate(String name, int rok, int miesiac, int dzien, Map<String, String> data) {
		super(name, "" + rok + "-" + miesiac + "-" + dzien);
		namespace("etd", data);
	}

}
