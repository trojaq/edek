package com.pecunia.edek.vat.siedem;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.pecunia.edek.common.Element;
import com.pecunia.edek.common.Globals;
import com.pecunia.edek.common.Oswiadczenie;
import com.pecunia.edek.common.Pouczenie;
import com.pecunia.edek.common.TDeklaracja;
import com.pecunia.edek.common.TIdentyfikatorOsobyFizycznejProsty;
import com.pecunia.edek.common.TIdentyfikatorOsobyNiefizycznej;
import com.pecunia.edek.common.TIdentyfikatorOsobyNiefizycznejBezRegonu;
import com.pecunia.edek.common.TPodmiotDowolny;
import com.pecunia.edek.common.TPodmiotDowolnyBezAdresu2;
import com.pecunia.edek.common.TPodmiotDowolnyBezAdresu2BezRegonu;
import com.pecunia.edek.common.TPodmiotDowolnyBezAdresu3;


public class Deklaracja extends TDeklaracja {

	static List<String> supported = Arrays.asList("10", "11", "12","14", "15", "16", "17", "18", "20");

	public Deklaracja(Map<String, String> data) {
		super("vat-7", supported, data);
		wersje.put("10", new WersjaPre14(data));
		wersje.put("11", new WersjaPre14(data));
		wersje.put("12", new WersjaPre14(data));
		wersje.put("14", new Wersja14(data));
		wersje.put("15", new Wersja15(data));
		wersje.put("16", new Wersja16(data));
		wersje.put("17", new Wersja17(data));
		wersje.put("18", new Wersja18(data));
		wersje.put("20", new Wersja20(data));
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

	public void setPozycjeSzczegolowe(PozycjeSzczegolowe pozszczeg) {
		subElements.put("PozycjeSzczegolowe", pozszczeg);
	}


	public TNaglowek getNaglowek() {
		return (TNaglowek) getSub("Naglowek");

	}
	
	private class WersjaPre14 extends Wersja {
		WersjaPre14(Map<String, String> input) {
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
	
	private class Wersja14 extends Wersja {
		Wersja14(Map<String, String> input) {
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
	private class Wersja15 extends Wersja {
		Wersja15(Map<String, String> input) {
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
	private class Wersja16 extends Wersja {
		Wersja16(Map<String, String> input) {
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
	
	private class Wersja17 extends Wersja {
		Wersja17(Map<String, String> input) {
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
	private class Wersja18 extends Wersja {
		Wersja18(Map<String, String> input) {
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
	private class Wersja20 extends Wersja {
		Wersja20(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
//			TPodmiotDowolnyBezAdresu2BezRegonu podmiot = new TPodmiotDowolnyBezAdresu2BezRegonu(input, "");
			Element podmiot = new Element();

			String of = input.get("RodzajPodatnika");
			if ("1".equals(of)) {
				podmiot.setSub("Osoba", new TIdentyfikatorOsobyNiefizycznejBezRegonu(input, false, false));	
			} else {
				podmiot.setSub("Osoba", new TIdentyfikatorOsobyFizycznejProsty(input, ""));
				
			}
			podmiot.setName("Podmiot1");
			podmiot.getAttributes().put("rola", "Podatnik");
			subElements.put("Podmiot1", podmiot);

		}
		
		public void pouczenia() {
			subElements.put("Pouczenia", new Pouczenie("Pouczenia", input));
			
		}
	}

}
