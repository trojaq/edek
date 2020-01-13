package com.pecunia.edek.vat.siedem;

import java.util.HashMap;
import java.util.Map;

import com.pecunia.edek.common.Element;
import com.pecunia.edek.common.TCelZlozenia;
import com.pecunia.edek.common.TKodUS;
import com.pecunia.edek.common.TMiesiac;
import com.pecunia.edek.common.TRok;
import com.pecunia.edek.common.WariantFormularza;

public class TNaglowek extends Element {


	public TNaglowek(Map<String, String> data) {
		super();
		name = "Naglowek";
		setKod(new TKodFormularza(data));
		setWariant(new WariantFormularza(data.get("wersja")));
		setCelZlozenia(data.get("Cel"));
		setRok(data);
		setMiesiac(data.get("Miesiac"));
		setKodUS(data.get("KodUS"));
	}

	public void setKodUS(String kod) {
		subElements.put("KodUrzedu", new TKodUS(kod));
	}

	public void setMiesiac(String mies) {
		subElements.put("Miesiac", new TMiesiac(mies));
	}

	public void setRok(Map<String, String> data) {
		subElements.put("Rok", new TRok(data));
	}

	private void setWariant(WariantFormularza wariantFormularza) {
		subElements.put("WariantFormularza", wariantFormularza);
	}

	public void setCelZlozenia(String num) {
		TCelZlozenia cel = new CelZlozenia();
		try {
			cel.setPierwsze(decodeEnumInt(num));
		} catch (NumberFormatException e) {
			System.out.println("Blad formatu celu zlozenia:" + num);
			throw e;
		}
		subElements.put("CelZlozenia", cel);
	}

	public void setKod(TKodFormularza kodFormularza) {
		subElements.put("KodFormularza", kodFormularza);
	}

	public class CelZlozenia extends TCelZlozenia {
		public CelZlozenia() {
			super();
			attributes.put("poz", "P_7");
		}

	}
}