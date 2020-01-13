package com.pecunia.edek.vat.siedem.d;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.pecunia.edek.common.Globals;
import com.pecunia.edek.common.Oswiadczenie;
import com.pecunia.edek.common.Pouczenie;
import com.pecunia.edek.common.TDeklaracja;
import com.pecunia.edek.common.TPodmiotDowolny;
import com.pecunia.edek.common.TPodmiotDowolnyBezAdresu2;
import com.pecunia.edek.common.TPodmiotDowolnyBezAdresu3;

public class Deklaracja extends TDeklaracja {

	static List<String> supported = Arrays.asList("1", "2", "3","5", "6");

	public Deklaracja(Map<String, String> data) {
		super("vat-7d", supported, data);
		wersje.put("1", new WersjaPre5(data));
		wersje.put("2", new WersjaPre5(data));
		wersje.put("3", new WersjaPre5(data));
		wersje.put("5", new Wersja5(data));
		wersje.put("6", new Wersja6(data));
		newSchemaName("Deklaracja "+Globals.getProp("schema", data), data);
//		newSchemaName(
//				"Deklaracja xsi:schemaLocation=\"http://"+Globals.getProp("schemaLocation", data)+"/ http://"+Globals.getProp("schemaWzor",data)+"\" xmlns=\"http://"+Globals.getProp("xmlns",data)+"/\" xmlns:etd=\"http://"+Globals.getProp("xmlns_edt",data)+"/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"",
//				data);
		setEndName("Deklaracja");
		setNaglowek(new TNaglowek(data));
		wypelnij(data.get("wersja"));
		setPozycjeSzczegolowe(new PozycjeSzczegolowe(data));
		wersje.get(data.get("wersja")).pouczenia();

	}

	public void setNaglowek(TNaglowek naglowek) {
		subElements.put("Naglowek", naglowek);
	}

	public void setPodmiot1(TPodmiotDowolny podmiot) {
		subElements.put("Podmiot1", podmiot);
	}

	public void setPozycjeSzczegolowe(PozycjeSzczegolowe pozszczeg) {
		subElements.put("PozycjeSzczegolowe", pozszczeg);
	}


	public TNaglowek getNaglowek() {
		return (TNaglowek) getSub("Naglowek");

	}
	private class WersjaPre5 extends Wersja {
		WersjaPre5(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			TPodmiotDowolny podmiot = new TPodmiotDowolny(input, "");
			podmiot.setName("Podmiot1");
			podmiot.getAttributes().put("rola", "Podatnik");
			subElements.put("Podmiot1", podmiot);

		}
		public void pouczenia() {
			subElements.put("Pouczenie", new Pouczenie(input));
			subElements.put("Oswiadczenie", new Oswiadczenie(input));
		}
	}
	
	private class Wersja5 extends Wersja {
		Wersja5(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			TPodmiotDowolnyBezAdresu2 podmiot = new TPodmiotDowolnyBezAdresu2(input, "");
			podmiot.setName("Podmiot1");
			podmiot.getAttributes().put("rola", "Podatnik");
			subElements.put("Podmiot1", podmiot);

		}
		public void pouczenia() {
			subElements.put("Pouczenie", new Pouczenie(input));
			subElements.put("Oswiadczenie", new Oswiadczenie(input));
		}
	}

	private class Wersja6 extends Wersja {
		Wersja6(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			TPodmiotDowolnyBezAdresu3 podmiot = new TPodmiotDowolnyBezAdresu3(input, "");
			podmiot.setName("Podmiot1");
			podmiot.getAttributes().put("rola", "Podatnik");
			subElements.put("Podmiot1", podmiot);

		}
		public void pouczenia() {
			subElements.put("Pouczenie1", new Pouczenie("Pouczenie1", input));
			subElements.put("Pouczenie2", new Oswiadczenie("Pouczenie2", input));
		}
	}

}

