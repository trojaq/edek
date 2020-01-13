package com.pecunia.edek.pit.jedenascie;

import java.util.Map;

import com.pecunia.edek.common.TPozycjeSzczegoloweUnsorted;

public class PozycjeSzczegolowe extends TPozycjeSzczegoloweUnsorted {

	public PozycjeSzczegolowe(Map<String, String> input) {
		super();
		wersje.put("17", new Wersja17(input));
		wersje.put("19", new Wersja19(input));
		wersje.put("20", new Wersja20i21(input));
		wersje.put("21", new Wersja20i21(input));
		wersje.put("23", new Wersja23(input));
		wersje.put("24", new Wersja24(input));
		wypelnij(input.get("wersja"));
	}

	private class Wersja17 extends Wersja {
		Wersja17(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			setPoz(36, input.get("36"));
			try {
				setPoz(35, "" + decodeEnumInt(input.get("35")));
			} catch (NumberFormatException e) {
				System.out.println("Blad formatu pozycji:" + 35);
				throw e;
			}
			for (int i = 37; i <= 81; i++) {
				setPoz(i, input.get("" + i));
			}
			try {
				setPoz(82, "" + decodeEnumInt(input.get("82")));
			} catch (NumberFormatException e) {
				System.out.println("Blad formatu pozycji:" + 82);
				throw e;
			}
		}
	}

	private class Wersja19 extends Wersja {
		Wersja19(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			try {
				setPoz(34, "" + decodeEnumInt(input.get("34")));
			} catch (NumberFormatException e) {
				System.out.println("Blad formatu pozycji:" + 34);
				throw e;
			}
			for (int i = 35; i <= 80; i++) {
				setPoz(i, input.get("" + i));
			}
			try {
				setPoz(81, "" + decodeEnumInt(input.get("81")));
			} catch (NumberFormatException e) {
				System.out.println("Blad formatu pozycji:" + 81);
				throw e;
			}
		}
	}

	private class Wersja20i21 extends Wersja {
		Wersja20i21(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			try {
				setPoz(24, "" + decodeEnumInt(input.get("24")));
			} catch (NumberFormatException e) {
				System.out.println("Blad formatu pozycji:" + 24);
				throw e;
			}
			for (int i = 25; i <= 71; i++) {
				setPoz(i, input.get("" + i));
			}
			try {
				setPoz(72, "" + decodeEnumInt(input.get("72")));
			} catch (NumberFormatException e) {
				System.out.println("Blad formatu pozycji:" + 72);
				throw e;
			}
		}
	}
	
	private class Wersja23 extends Wersja {
		Wersja23(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			//zawsze nieograniczony (rezydent)
			setPoz(10,"1");
			try {
				setPoz(28, "" + decodeEnumInt(input.get("28")));
			} catch (NumberFormatException e) {
				System.out.println("Blad formatu pozycji:" + 28);
				throw e;
			}
			for (int i = 29; i <= 75; i++) {
				setPoz(i, input.get("" + i));
			}
			try {
				setPoz(76, "" + decodeEnumInt(input.get("76")));
			} catch (NumberFormatException e) {
				System.out.println("Blad formatu pozycji:" + 76);
				throw e;
			}
		}
	}
	private class Wersja24 extends Wersja {
		Wersja24(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			//zawsze nieograniczony (rezydent)
			setPoz(10,"1");
			try {
				setPoz(28, "" + decodeEnumInt(input.get("28")));
			} catch (NumberFormatException e) {
				System.out.println("Blad formatu pozycji:" + 28);
				throw e;
			}
			for (int i = 29; i <= 84; i++) {
				setPoz(i, input.get("" + i));
			}
			try {
				setPoz(85, "" + decodeEnumInt(input.get("85")));
			} catch (NumberFormatException e) {
				System.out.println("Blad formatu pozycji:" + 76);
				throw e;
			}
		}
	}
}
