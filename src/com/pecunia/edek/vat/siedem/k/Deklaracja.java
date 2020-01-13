package com.pecunia.edek.vat.siedem.k;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.pecunia.edek.common.Globals;
import com.pecunia.edek.common.Oswiadczenie;
import com.pecunia.edek.common.Pouczenie;
import com.pecunia.edek.common.TDeklaracja;
import com.pecunia.edek.common.TPodmiotDowolny;
import com.pecunia.edek.common.TPodmiotDowolnyBezAdresu2;
import com.pecunia.edek.common.TPodmiotDowolnyBezAdresu2BezRegonu;
import com.pecunia.edek.common.Element.Wersja;
import com.pecunia.edek.common.TPodmiotDowolnyBezAdresu3;
import com.pecunia.edek.common.TPodmiotDowolnyProsty;



public class Deklaracja extends TDeklaracja {

	static List<String> supported = Arrays.asList("4", "5", "6","8", "9", "10", "11", "12", "14");

	public Deklaracja(Map<String, String> data) {
		super("vat-7k", supported, data);
		wersje.put("4", new WersjaPre8(data));
		wersje.put("5", new WersjaPre8(data));
		wersje.put("6", new WersjaPre8(data));
		wersje.put("8", new Wersja8(data));
		wersje.put("9", new Wersja9(data));
		wersje.put("10", new Wersja10(data));
		wersje.put("11", new Wersja11(data));
		wersje.put("12", new Wersja12(data));
		wersje.put("14", new Wersja14(data));
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
	
	private class WersjaPre8 extends Wersja {
		WersjaPre8(Map<String, String> input) {
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
	
	private class Wersja8 extends Wersja {
		Wersja8(Map<String, String> input) {
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
	private class Wersja9 extends Wersja {
		Wersja9(Map<String, String> input) {
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
	private class Wersja10 extends Wersja {
		Wersja10(Map<String, String> input) {
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
	private class Wersja11 extends Wersja {
		Wersja11(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			TPodmiotDowolnyBezAdresu2 podmiot = new TPodmiotDowolnyBezAdresu2(input, "");
			podmiot.setName("Podmiot1");
			podmiot.getAttributes().put("rola", "Podatnik");
			subElements.put("Podmiot1", podmiot);

		}
		
		public void pouczenia() {
			subElements.put("Pouczenia", new Pouczenie("Pouczenia", input));
			
		}
	}
	private class Wersja12 extends Wersja {
		Wersja12(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			TPodmiotDowolnyBezAdresu2BezRegonu podmiot = new TPodmiotDowolnyBezAdresu2BezRegonu(input, "");
			podmiot.setName("Podmiot1");
			podmiot.getAttributes().put("rola", "Podatnik");
			subElements.put("Podmiot1", podmiot);

		}
		
		public void pouczenia() {
			subElements.put("Pouczenia", new Pouczenie("Pouczenia", input));
			
		}
	}
	private class Wersja14 extends Wersja {
		Wersja14(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			TPodmiotDowolnyProsty podmiot = new TPodmiotDowolnyProsty(input, "", false);
			podmiot.setName("Podmiot1");
			podmiot.getAttributes().put("rola", "Podatnik");
			subElements.put("Podmiot1", podmiot);

		}
		
		public void pouczenia() {
			subElements.put("Pouczenia", new Pouczenie("Pouczenia", input));
			
		}
	}

}
