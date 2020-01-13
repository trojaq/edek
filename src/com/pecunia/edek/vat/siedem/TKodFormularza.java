package com.pecunia.edek.vat.siedem;

import java.util.Map;

import com.pecunia.edek.common.Element;
import com.pecunia.edek.common.Element.Wersja;

public class TKodFormularza extends Element {
	public TKodFormularza(Map<String, String> data) {
		wersje.put("12", new Wersja12(data));
		wersje.put("14", new Wersja14(data));
		wersje.put("15", new Wersja15i18(data));
		wersje.put("16", new Wersja16i17i20(data));
		wersje.put("17", new Wersja16i17i20(data));
		wersje.put("18", new Wersja15i18(data));
		wersje.put("20", new Wersja16i17i20(data));
		name = "KodFormularza";
		value = "VAT-7";
		attributes.put("kodSystemowy", "VAT-7 (" + data.get("wersja") + ")");
		attributes.put("kodPodatku", "VAT");
		attributes.put("rodzajZobowiazania", "Z");
		wypelnij(data.get("wersja"));
	}
	
	private class Wersja12 extends Wersja {
		Wersja12(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			attributes.put("wersjaSchemy", "1-0");
		}
	}

	private class Wersja14 extends Wersja {
		Wersja14(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			attributes.put("wersjaSchemy", "1-0E");
		}
	}

	private class Wersja15i18 extends Wersja {
		Wersja15i18(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			attributes.put("wersjaSchemy", "1-1E");
		}
	}
	
	private class Wersja16i17i20 extends Wersja {
		Wersja16i17i20(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			attributes.put("wersjaSchemy", "1-0E");
		}
	}
}
