package com.pecunia.edek.common;

import java.util.Map;

public class TKodKraju extends Element {

	public TKodKraju(String kod, Map<String, String> data) {
		name = "KodKraju";
		namespace("etd", data);
		TKodKrajuEnum kraj = TKodKrajuEnum.fromValue(kod);
		if (kraj == null) {
			System.out.println("Niepoprawny kod kraju:" + kod);
			throw new IllegalArgumentException();
		}
		if(data.containsKey("KodKrajuPoz")) {
			getAttributes().put("poz", data.get("KodKrajuPoz"));
		}
		value = kraj.shortName;
	}

}
