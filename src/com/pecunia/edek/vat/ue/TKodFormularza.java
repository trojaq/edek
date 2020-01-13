package com.pecunia.edek.vat.ue;

import java.util.Map;

import com.pecunia.edek.common.Element;

public class TKodFormularza extends Element {
	public TKodFormularza(Map<String, String> data) {
		name = "KodFormularza";
		value = "VAT-UE";
		if ("2".equals(data.get("wersja"))) {
			attributes
			.put("kodSystemowy", "VAT-UE (2)");
		} else if ("1".equals(data.get("wersja"))){
			attributes
					.put("kodSystemowy", "VAT-UE(1)");
		} else if ("4".equals(data.get("wersja"))){
			attributes
			.put("kodSystemowy", "VAT-UE (4)");
		}	
		if("4".equals(data.get("wersja"))) {
			attributes
			.put("wersjaSchemy", "1-0E");
		}
	}
}
