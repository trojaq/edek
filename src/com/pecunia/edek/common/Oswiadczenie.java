package com.pecunia.edek.common;

import java.util.Map;

public class Oswiadczenie extends Element {

	public Oswiadczenie(String name, Map<String, String> data) {
		this.name = name;
		value = Globals.props.getProperty(data.get("deklaracja").toLowerCase() + "-" + data.get("wersja") +".oswiadczenie");
	}

	public Oswiadczenie(Map<String, String> data) {
		this("Oswiadczenie", data);
	}
}
