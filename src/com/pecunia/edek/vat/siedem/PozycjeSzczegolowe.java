package com.pecunia.edek.vat.siedem;

import java.util.Map;

import com.pecunia.edek.common.TPozycjeSzczegoloweSorted;

public class PozycjeSzczegolowe extends TPozycjeSzczegoloweSorted {

	public PozycjeSzczegolowe(Map<String, String> input) {
		super();
		wersje.put("10", new Wersja10(input));
		wersje.put("11", new Wersja11(input));
		wersje.put("12", new Wersja12(input));
		wersje.put("14", new Wersja14(input));
		wersje.put("15", new Wersja15(input));
		wersje.put("16", new Wersja16(input));
		wersje.put("17", new Wersja17(input));
		wersje.put("18", new Wersja18(input));
		wersje.put("20", new Wersja20(input));
		wypelnij(input.get("wersja"));
	}

	private class Wersja10 extends Wersja {
		Wersja10(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			for (int i = 20; i <= 62; i++) {
				setPoz(i, input.get("" + i));
			}
			for (int i = 63; i <= 66; i++) {
				if ("1".equals(input.get("" + i))) {
					setPoz(i, "1");
				}
			}
			for (int i = 67; i <= 68; i++) {
				try {
					setPoz(i, "" + decodeEnumInt(input.get("" + i)));
				} catch (NumberFormatException e) {
					System.out.println("Blad formatu pozycji:" + i);
					throw e;
				}
			}
		}
	}

	private class Wersja11 extends Wersja {
		Wersja11(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			for (int i = 20; i <= 65; i++) {
				setPoz(i, input.get("" + i));
			}
			for (int i = 66; i <= 70; i++) {
				if ("1".equals(input.get("" + i))) {
					setPoz(i, "1");
				}
			}
			for (int i = 71; i <= 72; i++) {
				try {
					setPoz(i, "" + decodeEnumInt(input.get("" + i)));
				} catch (NumberFormatException e) {
					System.out.println("Blad formatu pozycji:" + i);
					throw e;
				}
			}
		}
	}

	private class Wersja12 extends Wersja {
		Wersja12(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			for (int i = 20; i <= 65; i++) {
				setPoz(i, input.get("" + i));
			}
			for (int i = 66; i <= 69; i++) {
				if ("1".equals(input.get("" + i))) {
					setPoz(i, "1");
				}
			}
			for (int i = 70; i <= 71; i++) {
				try {
					setPoz(i, "" + decodeEnumInt(input.get("" + i)));
				} catch (NumberFormatException e) {
					System.out.println("Blad formatu pozycji:" + i);
					throw e;
				}
			}
		}
	}

	private class Wersja14 extends Wersja {
		Wersja14(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			for (int i = 10; i <= 55; i++) {
				setPoz(i, input.get("" + i));
			}
			for (int i = 56; i <= 59; i++) {
				if ("1".equals(input.get("" + i))) {
					setPoz(i, "1");
				}
			}
			for (int i = 60; i <= 63; i++) {
				try {
					setPoz(i, "" + decodeEnumInt(input.get("" + i)));
				} catch (NumberFormatException e) {
					System.out.println("Blad formatu pozycji:" + i);
					throw e;
				}
			}
			setPoz(68,input.get("68"),true);
			setPoz(69,input.get("69"),false);
		}
	}
	private class Wersja15 extends Wersja {
		Wersja15(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			for (int i = 10; i <= 58; i++) {
				setPoz(i, input.get("" + i));
			}
			for (int i = 59; i <= 62; i++) {
				if ("1".equals(input.get("" + i))) {
					setPoz(i, "1");
				}
			}
			for (int i = 63; i <= 66; i++) {
				try {
					setPoz(i, "" + decodeEnumInt(input.get("" + i)));
				} catch (NumberFormatException e) {
					System.out.println("Blad formatu pozycji:" + i);
					throw e;
				}
			}
			setPoz(71,input.get("71"),true);
			setPoz(72,input.get("72"),false);
		}
	}
	private class Wersja16 extends Wersja {
		Wersja16(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			for (int i = 10; i <= 59; i++) {
				setPoz(i, input.get("" + i));
			}
			for (int i = 60; i <= 63; i++) {
				if ("1".equals(input.get("" + i))) {
					setPoz(i, "1");
				}
			}
			for (int i = 64; i <= 67; i++) {
				try {
					setPoz(i, "" + decodeEnumInt(input.get("" + i)));
				} catch (NumberFormatException e) {
					System.out.println("Blad formatu pozycji:" + i);
					throw e;
				}
			}
			setPoz(72,input.get("72"),true);
			setPoz(73,input.get("73"),false);
		}
	}
	private class Wersja17 extends Wersja {
		Wersja17(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			for (int i = 10; i <= 61; i++) {
				setPoz(i, input.get("" + i));
			}
			for (int i = 62; i <= 65; i++) {
				if ("1".equals(input.get("" + i))) {
					setPoz(i, "1");
				}
			}
			for (int i = 66; i <= 68; i++) {
				try {
					setPoz(i, "" + decodeEnumInt(input.get("" + i)));
				} catch (NumberFormatException e) {
					System.out.println("Blad formatu pozycji:" + i);
					throw e;
				}
			}
			setPoz(73,input.get("73"),true);
			setPoz(74,input.get("74"),false);
		}
	}
	private class Wersja18 extends Wersja {
		Wersja18(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			setUnsorted();
			for (int i = 10; i <= 57; i++) {
				setPoz(i, input.get("" + i));
			}
			int p58 = decodeEnumInt(input.get("58"));
			int p59 = decodeEnumInt(input.get("59"));
			int p60 = decodeEnumInt(input.get("60"));
			int p61 = decodeEnumInt(input.get("61"));
			if(p58 > 0) {
				setPoz(58, "" + p58);
				setPoz(68, input.get("68"));
			} else if(p59 > 0) {
				setPoz(59, "" + p59);
				setPoz(70, input.get("70"));
			} else if(p60 > 0) {
				setPoz(60, "" + p60);
			} else if(p61 > 0) {
				setPoz(61, "" + p61);
			}
			setPoz(69, input.get("69"));
			setPoz(62, input.get("62"));

			for (int i = 63; i <= 67; i++) {
				if ("1".equals(input.get("" + i))) {
					setPoz(i, "1");
				}
			}
			setPoz(71, input.get("71"), true);
			setPoz(74, input.get("74"), true);
			setPoz(75,input.get("75"),true);
			setPoz(76,input.get("76"),true);
		}
	}
	private class Wersja20 extends Wersja {
		Wersja20(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			setUnsorted();
			for (int i = 10; i <= 57; i++) {
				setPoz(i, input.get("" + i));
			}
			int p58 = decodeEnumInt(input.get("58"));
			int p59 = decodeEnumInt(input.get("59"));
			int p60 = decodeEnumInt(input.get("60"));
			int p61 = decodeEnumInt(input.get("61"));
			if(p58 > 0) {
				setPoz(58, "" + p58);
				setPoz(68, input.get("68"));
			} else if(p59 > 0) {
				setPoz(59, "" + p59);
			} else if(p60 > 0) {
				setPoz(60, "" + p60);
			} else if(p61 > 0) {
				setPoz(61, "" + p61);
			}
			setPoz(62, input.get("62"));

			for (int i = 63; i <= 67; i++) {
				if ("1".equals(input.get("" + i))) {
					setPoz(i, "1");
				}
			}
			if ("1".equals(input.get("69"))) {
				setPoz(69, "1");
			}
			setPoz(70, input.get("70"), true);
			setPoz(73, input.get("73"), true);
			setPoz(74,input.get("74"),true);
			setPoz(75,input.get("75"),true);
		}
	}
}
