package com.pecunia.edek.common;

import java.util.Map;

public class Pouczenie extends Element {

	public Pouczenie(Map<String, String> data) {
		this("Pouczenie", data);	
	}

	public Pouczenie(String name, Map<String, String> data) {
		this.name = name;
		value = Globals.props.getProperty(data.get("deklaracja").toLowerCase() + "-" + data.get("wersja") +".pouczenie");
	}
}
