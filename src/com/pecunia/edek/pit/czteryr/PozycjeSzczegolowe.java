package com.pecunia.edek.pit.czteryr;

import java.util.Map;

import com.pecunia.edek.common.TPozycjeSzczegoloweUnsorted;
import com.pecunia.edek.common.TTekstowy;

public class PozycjeSzczegolowe extends TPozycjeSzczegoloweUnsorted {

	public PozycjeSzczegolowe(Map<String, String> input) {
		super();
//		wersje.put("3", new Wersja3(input));
		wersje.put("3", new Wersja3E(input));
		wersje.put("4", new Wersja4i5i6i8(input));
		wersje.put("5", new Wersja4i5i6i8(input));
		wersje.put("6", new Wersja4i5i6i8(input));
		wersje.put("8", new Wersja4i5i6i8(input));
		wypelnij(input.get("wersja"));
	}

//	private class Wersja3 extends Wersja {
//		Wersja3(Map<String, String> input) {
//			super(input);
//		}
//
//		protected void fill() {
//			setPoz(19, input.get("19"), true);
//			setPoz(25, input.get("25"), true);
//			setPoz(20, input.get("20"), true);
//			setPoz(26, input.get("26"), true);
//			setPoz(21, input.get("21"), true);
//			setPoz(27, input.get("27"), true);
//			setPoz(22, input.get("22"), true);
//			setPoz(28, input.get("28"), true);
//			setPoz(23, input.get("23"), true);
//			setPoz(29, input.get("29"), true);
//			setPoz(24, input.get("24"), true);
//			setPoz(30, input.get("30"), true);
//			setPoz(31, input.get("31"), true);
//			setPoz(37, input.get("37"), true);
//			setPoz(32, input.get("32"), true);
//			setPoz(38, input.get("38"), true);
//			setPoz(33, input.get("33"), true);
//			setPoz(39, input.get("39"), true);
//			setPoz(34, input.get("34"), true);
//			setPoz(40, input.get("40"), true);
//			setPoz(35, input.get("35"), true);
//			setPoz(41, input.get("41"), true);
//			setPoz(36, input.get("36"), true);
//			setPoz(42, input.get("42"), true);
//
//			for (int i = 43; i <= 118; i++) {
//				setPoz(i, input.get("" + i), true);
//			}
//
//			for (int i = 119; i <= 166; i++) {
//				setPoz(i, input.get("" + i), true);
//			}
//
//			for (int i = 167; i <= 178; i++) {
//				setPoz(i, input.get("" + i), false);
//			}
//
//			String wyjasnienie = TTekstowy.getTekst(input, 179);
//			if (wyjasnienie != null) {
//				setPoz(179, wyjasnienie, true);
//			}
//
//		}
//	}

	private class Wersja3E extends Wersja {
		Wersja3E(Map<String, String> input) {
			super(input);
		}

		protected void fill() {

			for (int i = 19; i <= 118; i++) {
				setPoz(i, input.get("" + i), true);
			}

			for (int i = 119; i <= 166; i++) {
				setPoz(i, input.get("" + i), true);
			}

			for (int i = 167; i <= 178; i++) {
				setPoz(i, input.get("" + i), false);
			}

			String wyjasnienie = TTekstowy.getTekst(input, 179);
			if (wyjasnienie != null) {
				setPoz(179, wyjasnienie, true);
			}

		}
	}

	private class Wersja4i5i6i8 extends Wersja {
		Wersja4i5i6i8(Map<String, String> input) {
			super(input);
		}

		protected void fill() {

			for (int i = 9; i <= 156; i++) {
				setPoz(i, input.get("" + i), true);
			}
			for (int i = 157; i <= 168; i++) {
				setPoz(i, input.get("" + i), false);
			}

			String wyjasnienie = TTekstowy.getTekst(input, 169);
			if (wyjasnienie != null) {
				setPoz(169, wyjasnienie, true);
			}

		}
	}
}
