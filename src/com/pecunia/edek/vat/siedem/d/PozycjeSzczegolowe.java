package com.pecunia.edek.vat.siedem.d;

import java.util.Map;

import com.pecunia.edek.common.TPozycjeSzczegoloweSorted;

public class PozycjeSzczegolowe extends TPozycjeSzczegoloweSorted {

	public PozycjeSzczegolowe(Map<String, String> input) {
		super();
		wersje.put("1", new Wersja1(input));
		wersje.put("2", new Wersja2(input));
		wersje.put("3", new Wersja3(input));
		wersje.put("5", new Wersja5(input));
		wersje.put("6", new Wersja6(input));
		wypelnij(input.get("wersja"));
	}

	private class Wersja1 extends Wersja {
		Wersja1(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			setPoz(45, "0");
			setPoz(46, "0");
			setPoz(61, "0");

			for (int i = 20; i < 57; i++) {
				setPoz(i, input.get("" + i));
			}
			try {
				int p58 = Integer.parseInt(input.get("58"));
				int p59 = Integer.parseInt(input.get("59"));
				if (p58 >= p59) {
					setPoz(58, input.get("58"));
				} else {
					setPoz(59, input.get("59"));
				}
			} catch (NumberFormatException e) {
				System.out.println("Blad formatu pozycji 58 lub 59");
				throw e;
			}

			try {
				setPoz(60, "" + decodeEnumInt(input.get("60")));
			} catch (NumberFormatException e) {
				System.out.println("Blad formatu pozycji 60");
				throw e;
			}
			for (int i = 61; i < 69; i++) {
				setPoz(i, input.get("" + i));
			}
			for (int i = 69; i <= 72; i++) {
				if ("1".equals(input.get("" + i))) {
					setPoz(i, "1");
				}
			}
			for (int i = 73; i <= 75; i++) {
				if ("".equals(input.get("" + i))) {
					continue;
				}
				try {
					setPoz(i, "" + decodeEnumInt(input.get("" + i)));
				} catch (NumberFormatException e) {
					System.out.println("Blad formatu pozycji:" + i);
					throw e;
				}
			}

		}
	}

	private class Wersja2 extends Wersja {
		Wersja2(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			setPoz(45, "0");
			setPoz(46, "0");
			setPoz(61, "0");

			for (int i = 20; i < 63; i++) {
				setPoz(i, input.get("" + i));
			}

			try {
				setPoz(63, "" + decodeEnumInt(input.get("63")));
			} catch (NumberFormatException e) {
				System.out.println("Blad formatu pozycji 63");
				throw e;
			}
			for (int i = 64; i <= 71; i++) {
				setPoz(i, input.get("" + i));
			}
			for (int i = 72; i <= 76; i++) {
				if ("1".equals(input.get("" + i))) {
					setPoz(i, "1");
				}
			}
			for (int i = 77; i <= 79; i++) {
				if ("".equals(input.get("" + i))) {
					continue;
				}
				try {
					setPoz(i, "" + decodeEnumInt(input.get("" + i)));
				} catch (NumberFormatException e) {
					System.out.println("Blad formatu pozycji:" + i);
					throw e;
				}
			}

		}
	}
	private class Wersja3 extends Wersja {
		Wersja3(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			setPoz(45, "0");
			setPoz(46, "0");
			setPoz(61, "0");
			setPoz(58, "0");
			setPoz(59, "0");

			for (int i = 20; i < 63; i++) {
				setPoz(i, input.get("" + i));
			}

			try {
				setPoz(63, "" + decodeEnumInt(input.get("63")));
			} catch (NumberFormatException e) {
				System.out.println("Blad formatu pozycji 63");
				throw e;
			}
			for (int i = 64; i <= 71; i++) {
				setPoz(i, input.get("" + i));
			}
			for (int i = 72; i <= 75; i++) {
				if ("1".equals(input.get("" + i))) {
					setPoz(i, "1");
				}
			}
			for (int i = 76; i <= 78; i++) {
				if ("".equals(input.get("" + i))) {
					continue;
				}
				try {
					setPoz(i, "" + decodeEnumInt(input.get("" + i)));
				} catch (NumberFormatException e) {
					System.out.println("Blad formatu pozycji:" + i);
					throw e;
				}
			}

		}
	}
	private class Wersja5 extends Wersja {
		Wersja5(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			for (int i = 10; i < 53; i++) {
				setPoz(i, input.get("" + i));
			}

			try {
				setPoz(53, "" + decodeEnumInt(input.get("53")));
			} catch (NumberFormatException e) {
				System.out.println("Blad formatu pozycji 53");
				throw e;
			}
			for (int i = 54; i <= 61; i++) {
				setPoz(i, input.get("" + i));
			}
			for (int i = 62; i <= 65; i++) {
				if ("1".equals(input.get("" + i))) {
					setPoz(i, "1");
				}
			}
			for (int i = 66; i <= 70; i++) {
				if ("".equals(input.get("" + i))) {
					continue;
				}
				try {
					setPoz(i, "" + decodeEnumInt(input.get("" + i)));
				} catch (NumberFormatException e) {
					System.out.println("Blad formatu pozycji:" + i);
					throw e;
				}
			}
			setPoz(75,input.get("75"),true);
			setPoz(76,input.get("76"),false);

		}
	}
	private class Wersja6 extends Wersja {
		Wersja6(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			for (int i = 10; i < 56; i++) {
				setPoz(i, input.get("" + i));
			}

			try {
				setPoz(56, "" + decodeEnumInt(input.get("56")));
			} catch (NumberFormatException e) {
				System.out.println("Blad formatu pozycji 56");
				throw e;
			}
			for (int i = 57; i <= 64; i++) {
				setPoz(i, input.get("" + i));
			}
			for (int i = 65; i <= 68; i++) {
				if ("1".equals(input.get("" + i))) {
					setPoz(i, "1");
				}
			}
			for (int i = 69; i <= 73; i++) {
				if ("".equals(input.get("" + i))) {
					continue;
				}
				try {
					setPoz(i, "" + decodeEnumInt(input.get("" + i)));
				} catch (NumberFormatException e) {
					System.out.println("Blad formatu pozycji:" + i);
					throw e;
				}
			}
			setPoz(78,input.get("78"),true);
			setPoz(79,input.get("79"),false);

		}
	}

}
