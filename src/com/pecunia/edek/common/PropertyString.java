package com.pecunia.edek.common;

import java.util.Map;

public class PropertyString extends Element {

	public PropertyString(String name, Map<String, String> data) {
		this.name = name;
		value = Globals.getProp(name.toLowerCase(), data);
	}

}
