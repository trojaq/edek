package com.pecunia.edek.vat.siedem.k;

import java.util.Map;

import com.pecunia.edek.common.Element;

public class TKodFormularza extends Element {
	public TKodFormularza(Map<String, String> data) {
		wersje.put("6", new Wersja6(data));
		wersje.put("8", new Wersja8(data));
		wersje.put("9", new Wersja9(data));
		wersje.put("10", new Wersja10(data));
		wersje.put("11", new Wersja11(data));
		wersje.put("12", new Wersja12(data));
		wersje.put("14", new Wersja14(data));
		name = "KodFormularza";
		value = "VAT-7K";
		attributes.put("kodSystemowy", "VAT-7K (" + data.get("wersja") + ")");
		attributes.put("kodPodatku", "VAT");
		attributes.put("rodzajZobowiazania", "Z");
		wypelnij(data.get("wersja"));
	}

	private class Wersja6 extends Wersja {
		Wersja6(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			attributes.put("wersjaSchemy", "1-1");
		}
	}
	private class Wersja8 extends Wersja {
		Wersja8(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			attributes.put("wersjaSchemy", "1-0E");
		}
	}
	private class Wersja9 extends Wersja {
		Wersja9(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			attributes.put("wersjaSchemy", "1-0E");
		}
	}
	private class Wersja10 extends Wersja {
		Wersja10(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			attributes.put("wersjaSchemy", "1-0E");
		}
	}
	private class Wersja11 extends Wersja {
		Wersja11(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			attributes.put("wersjaSchemy", "1-0E");
		}
	}
	private class Wersja12 extends Wersja {
		Wersja12(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			attributes.put("wersjaSchemy", "1-2E");
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

}
