package com.pecunia.edek.common;

import java.util.Map;

public class TMiejscowosc extends Element {

	public TMiejscowosc(String name) {
		super("Miejscowosc", name);
	}

	public TMiejscowosc(String name, String value, Map<String, String> data) {
		super(name, value);
		namespace("etd", data);
	}

}
