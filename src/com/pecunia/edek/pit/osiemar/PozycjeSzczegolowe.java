package com.pecunia.edek.pit.osiemar;

import java.util.Map;

import com.pecunia.edek.common.TPozycjeSzczegoloweUnsorted;
import com.pecunia.edek.common.TTekstowy;

public class PozycjeSzczegolowe extends TPozycjeSzczegoloweUnsorted {

	public PozycjeSzczegolowe(Map<String, String> input) {
		super();
		wersje.put("1", new Wersja1(input));
		wypelnij(input.get("wersja"));
	}

	private class Wersja1 extends Wersja {
		Wersja1(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			for (int i = 19; i <= 210; i++) {
				setPoz(i, input.get("" + i), false);
			}

		}
	}

}
