package com.pecunia.edek.common;

import java.util.Map;

public class TNrLokalu extends Element {

	public TNrLokalu(String name, Map<String, String> data) {
		super("NrLokalu", name);
		namespace("etd", data);
	}

}
