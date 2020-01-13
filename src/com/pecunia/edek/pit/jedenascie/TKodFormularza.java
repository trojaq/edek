package com.pecunia.edek.pit.jedenascie;

import java.util.Map;

import com.pecunia.edek.common.Element;

public class TKodFormularza extends Element {
	public TKodFormularza(Map<String, String> data) {
		wersje.put("19", new Wersja19i20i21(data));
		//wersja 20 taka sama
		wersje.put("20", new Wersja19i20i21(data));
		//wersja 21 taka sama
		wersje.put("21", new Wersja19i20i21(data));
		wersje.put("23", new Wersja23(data));
		wersje.put("24", new Wersja24(data));
		name = "KodFormularza";
		value = "PIT-11";
		attributes.put("kodSystemowy", "PIT-11 (" + data.get("wersja") + ")");
		attributes.put("kodPodatku", "PIT");
		attributes.put("rodzajZobowiazania", "Z");
		wypelnij(data.get("wersja"));
	}
	
	private class Wersja19i20i21 extends Wersja {
		Wersja19i20i21(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			attributes.put("wersjaSchemy", "1-0E");
		}
	}

	private class Wersja23 extends Wersja {
		Wersja23(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			attributes.put("wersjaSchemy", "1-0E");
		}
	}
	private class Wersja24 extends Wersja {
		Wersja24(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			attributes.put("wersjaSchemy", "1-0E");
		}
	}

}
