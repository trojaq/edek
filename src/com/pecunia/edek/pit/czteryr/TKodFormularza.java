package com.pecunia.edek.pit.czteryr;

import java.util.Map;

import com.pecunia.edek.common.Element;

public class TKodFormularza extends Element {
	public TKodFormularza(Map<String, String> data) {
		wersje.put("3", new Wersja3Ei5i6i8(data));
		wersje.put("4", new Wersja4(data));
		wersje.put("5", new Wersja3Ei5i6i8(data));
		wersje.put("6", new Wersja3Ei5i6i8(data));
		wersje.put("8", new Wersja3Ei5i6i8(data));
		name = "KodFormularza";
		value = "PIT-4R";
		String wersja = data.get("wersja");
		attributes.put("kodSystemowy", "PIT-4R (" + data.get("wersja") + ")");
		attributes.put("kodPodatku", "PIT");
		attributes.put("rodzajZobowiazania", "P");
		wypelnij(data.get("wersja"));
	}

	private class Wersja3Ei5i6i8 extends Wersja {
		Wersja3Ei5i6i8(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			attributes.put("wersjaSchemy", "1-0E");
		}
	}

	private class Wersja4 extends Wersja {
		Wersja4(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			attributes.put("wersjaSchemy", "1-1E");
		}
	}
}
