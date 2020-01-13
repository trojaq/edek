package com.pecunia.edek.vat.ue;

import java.util.Map;

import com.pecunia.edek.common.TPozycjeSzczegoloweSorted;

public class PozycjeSzczegolowe extends TPozycjeSzczegoloweSorted {

	public PozycjeSzczegolowe(Map<String, String> input) {
		super();

		for (int num = 1; input.get("D1_" + num) != null; num++) {
			setDostawy(num, new TDostawy(num, input));
		}
		for (int num = 1; input.get("N1_" + num) != null; num++) {
			setNabycia(num, new TNabycia(num, input));
		}
		for (int num = 1; input.get("U1_" + num) != null; num++) {
			setUslugi(num, new TUslugi(num, input));
		}
	}

	public void setDostawy(int num, TDostawy grupa) {
		subElements.put("D_" + num, grupa);
	}

	public void setNabycia(int num, TNabycia grupa) {
		subElements.put("N_" + num, grupa);
	}

	public void setUslugi(int num, TUslugi grupa) {
		subElements.put("U_" + num, grupa);
	}
}
