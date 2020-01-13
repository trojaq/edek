package com.pecunia.edek.pit.osiemar;

import java.util.Map;

import com.pecunia.edek.common.Element;

public class TKodFormularza extends Element {
	public TKodFormularza(Map<String, String> data) {
		name = "KodFormularza";
		value = "PIT-8AR";
		attributes.put("kodSystemowy", "PIT-8AR (" + data.get("wersja") + ")");
		attributes.put("kodPodatku", "PPR");
		attributes.put("rodzajZobowiazania", "P");
	}
}
