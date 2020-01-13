package com.pecunia.edek.common;


public abstract class TPozycjeSzczegoloweUnsorted extends Element {

	public TPozycjeSzczegoloweUnsorted() {
		super("PozycjeSzczegolowe");
	}

	public void setPoz(int poz, String value) {
		setPozDirect(poz, value);
	}

	public void setPoz(int poz, String value, boolean optional) {
		if (optional && value == null) {
			return;
		} else if(!optional && value == null) {
			throw new IllegalArgumentException("Brakuje wartosci dla pozycji "+ poz );
		}
		setPozDirect(poz, value);
	}

	private void setPozDirect(int poz, String value) {
		System.out.println("Adding " + poz);
		Element el = new Element();
		el.setName("P_" + poz);
		el.setValue(value == null ? "0": value);
		subElements.put("P_" + poz, el);
	}

}
