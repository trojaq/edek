package com.pecunia.edek.vat.ue;

import java.util.Map;

import com.pecunia.edek.common.Element;
import com.pecunia.edek.common.TKodUS;
import com.pecunia.edek.common.TKwartal;
import com.pecunia.edek.common.TMiesiac;
import com.pecunia.edek.common.TRok;
import com.pecunia.edek.common.WariantFormularza;

public class TNaglowek extends Element {

	public TNaglowek(Map<String, String> data) {
		super();
		name = "Naglowek";
		setKod(new TKodFormularza(data));
		subElements.put("WariantFormularza", new WariantFormularza(data
				.get("wersja")));
		setRok(data);
		if ("2".equals(data.get("wersja"))) {
			if (data.get("Kwartal") != null && !"".equals(data.get("Kwartal"))) {
				setKwartal(data.get("Kwartal"));
			} else {
				setMiesiac(data.get("Miesiac"));
			}
			subElements.put("CelZlozenia", new CelZlozenia());
			setKodUS(data.get("KodUS"));
		} else if ("1".equals(data.get("wersja")))  {
			subElements.put("CelZlozenia", new CelZlozenia());
			setKwartal(data.get("Kwartal"));
			setKodUS(data.get("KodUS"));
		} else {
			setMiesiac(data.get("Miesiac"));
			subElements.put("CelZlozenia", new CelZlozenia());
			setKodUS(data.get("KodUS"));
		}
	}

	public void setKodUS(String kod) {
		subElements.put("KodUrzedu", new TKodUS(kod));
	}

	public void setKwartal(String kwar) {
		subElements.put("Kwartal", new TKwartal(kwar));
	}

	public void setMiesiac(String mies) {
		subElements.put("Miesiac", new TMiesiac(mies));
	}

	public void setRok(Map<String, String> data) {
		subElements.put("Rok", new TRok(data));
	}

	public void setKod(TKodFormularza kodFormularza) {
		subElements.put("KodFormularza", kodFormularza);
	}

	public class CelZlozenia extends Element {
		public CelZlozenia() {
			super("CelZlozenia", "1");
		}

	}
}