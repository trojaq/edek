package com.pecunia.edek.vat.siedem.d;

import java.util.Map;

import com.pecunia.edek.common.Element;

public class TKodFormularza extends Element {
	public TKodFormularza(Map<String, String> data) {
		wersje.put("3", new Wersja3(data));
		wersje.put("5", new Wersja5(data));
		wersje.put("6", new Wersja6(data));
		name = "KodFormularza";
		value = "VAT-7D";
		attributes.put("kodSystemowy", "VAT-7D (" + data.get("wersja") + ")");
		attributes.put("kodPodatku", "VAT");
		attributes.put("rodzajZobowiazania", "Z");
		wypelnij(data.get("wersja"));
	}
	
	private class Wersja3 extends Wersja {
		Wersja3(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			attributes.put("wersjaSchemy", "1-0");
		}
	}

	private class Wersja5 extends Wersja {
		Wersja5(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			attributes.put("wersjaSchemy", "1-0E");
		}
	}
	private class Wersja6 extends Wersja {
		Wersja6(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			attributes.put("wersjaSchemy", "1-0E");
		}
	}

}
