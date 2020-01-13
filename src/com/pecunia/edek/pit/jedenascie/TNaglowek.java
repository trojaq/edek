package com.pecunia.edek.pit.jedenascie;

import java.util.Map;

import com.pecunia.edek.common.Element;
import com.pecunia.edek.common.TCelZlozenia;
import com.pecunia.edek.common.TDate;
import com.pecunia.edek.common.TKodUS;
import com.pecunia.edek.common.TRok;
import com.pecunia.edek.common.WariantFormularza;

public class TNaglowek extends Element {


	public TNaglowek(Map<String, String> data) {
		super();
		wersje.put("17", new Wersja17(data));
		wersje.put("19", new Wersja19i20i21i23i24(data));
		wersje.put("20", new Wersja19i20i21i23i24(data));
		wersje.put("21", new Wersja19i20i21i23i24(data));
		wersje.put("23", new Wersja19i20i21i23i24(data));
		wersje.put("24", new Wersja19i20i21i23i24(data));
		name = "Naglowek";
		setKod(new TKodFormularza(data));
		setWariant(new WariantFormularza(data.get("wersja")));
		wypelnij(data.get("wersja"));
	}

	public void setKodUS(String kod) {
		subElements.put("KodUrzedu", new TKodUS(kod));
	}
	
	public void setRok(Map<String, String> data) {
		subElements.put("Rok", new TRok(data));
	}

	public void setOkresOd(Map<String, String> data) {
		TDate od = new TDate("OkresOd", data.get("OkresOd"), data);
		od.getAttributes().put("poz", "P_4");
		subElements.put("OkresOd", od);
	}

	public void setOkresDo(Map<String, String> data) {
		TDate okresDo = new TDate("OkresDo", data.get("OkresDo"), data);
		okresDo.getAttributes().put("poz", "P_5");
		subElements.put("OkresDo", okresDo);
	}

	private void setWariant(WariantFormularza wariantFormularza) {
		subElements.put("WariantFormularza", wariantFormularza);
	}

	public void setCelZlozenia(TCelZlozenia cel, String num) {
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
		public CelZlozenia(String poz) {
			super();
			attributes.put("poz", poz);
		}

	}
	
	private class Wersja17 extends Wersja {
		Wersja17(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			setCelZlozenia(new CelZlozenia("P_7"), input.get("Cel"));
			setOkresOd(input);
			setOkresDo(input);
			setKodUS(input.get("KodUS"));
		}

	}
	private class Wersja19i20i21i23i24 extends Wersja {
		Wersja19i20i21i23i24(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			setCelZlozenia(new CelZlozenia("P_6"), input.get("Cel"));
			setRok(input);
			setKodUS(input.get("KodUS"));
		}

	}
}