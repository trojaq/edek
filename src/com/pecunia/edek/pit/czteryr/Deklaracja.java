package com.pecunia.edek.pit.czteryr;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.pecunia.edek.common.Element;
import com.pecunia.edek.common.Globals;
import com.pecunia.edek.common.Oswiadczenie;
import com.pecunia.edek.common.Pouczenie;
import com.pecunia.edek.common.PropertyString;
import com.pecunia.edek.common.TAdresZamieszkaniaSiedziby;
import com.pecunia.edek.common.TDeklaracja;
import com.pecunia.edek.common.TOsobaFizyczna1;
import com.pecunia.edek.common.TPodmiotDowolny;
import com.pecunia.edek.common.TPodmiotDowolnyBezAdresu;
import com.pecunia.edek.common.TPodmiotDowolnyBezAdresu2;
import com.pecunia.edek.common.TPodmiotDowolnyBezAdresu3;

public class Deklaracja extends TDeklaracja {

	static List<String> supported = Arrays.asList("3","4","5", "6", "8");

	public Deklaracja(Map<String, String> data) {
		super("pit-4r", supported, data);
		newSchemaName("Deklaracja "+Globals.getProp("schema", data), data);
//		newSchemaName(
//				"Deklaracja xsi:schemaLocation=\"http://"+Globals.getProp("schemaLocation", data)+"/ http://"+Globals.getProp("schemaWzor",data)+"\" xmlns=\"http://"+Globals.getProp("xmlns",data)+"/\" xmlns:etd=\"http://"+Globals.getProp("xmlns_edt",data)+"/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"",
//				data);
		setEndName("Deklaracja");
//		wersje.put("3", new Wersja3(data));
		wersje.put("3", new Wersja3E(data));
		wersje.put("4", new Wersja4(data));
		wersje.put("5", new Wersja5(data));
		wersje.put("6", new Wersja6(data));
		wersje.put("8", new Wersja8(data));
		setNaglowek(new TNaglowek(data));
		wypelnij(data.get("wersja"));
	}

	public void setNaglowek(TNaglowek naglowek) {
		subElements.put("Naglowek", naglowek);
	}

	public void setPodmiot1(Element podmiot) {
		subElements.put("Podmiot1", podmiot);
	}


	public void setPozycjeSzczegolowe(PozycjeSzczegolowe pozszczeg) {
		subElements.put("PozycjeSzczegolowe", pozszczeg);
	}


	public TNaglowek getNaglowek() {
		return (TNaglowek) getSub("Naglowek");

	}
	
//	private class Wersja3 extends Wersja {
//		Wersja3(Map<String, String> input) {
//			super(input);
//		}
//
//		protected void fill() {
//			TPodmiotDowolny podmiot = new TPodmiotDowolny(input, "");
//			podmiot.setName("Podmiot1");
//			podmiot.getAttributes().put("rola", "P³atnik");
//			setPodmiot1(podmiot);
//		}
//	}

	private class Wersja3E extends Wersja {
		Wersja3E(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			TPodmiotDowolnyBezAdresu2 podmiot = new TPodmiotDowolnyBezAdresu2(input, "");
			podmiot.setName("Podmiot1");
			podmiot.getAttributes().put("rola", "P³atnik");
			podmiot.setSub("AdresZamieszkaniaSiedziby", new TAdresZamieszkaniaSiedziby(input));
			setPodmiot1(podmiot);
			setPozycjeSzczegolowe(new PozycjeSzczegolowe(input));
			subElements.put("Pouczenie", new Pouczenie(input));
			subElements.put("Oswiadczenie", new Oswiadczenie(input));

		}
	}
	
	private class Wersja4 extends Wersja {
		Wersja4(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			TPodmiotDowolnyBezAdresu2 podmiot = new TPodmiotDowolnyBezAdresu2(input, "");
			podmiot.setName("Podmiot1");
			podmiot.getAttributes().put("rola", "P³atnik");
			setPodmiot1(podmiot);
			setPozycjeSzczegolowe(new PozycjeSzczegolowe(input));
			subElements.put("Pouczenie1", new PropertyString("Pouczenie1", input));
			subElements.put("Pouczenie2", new PropertyString("Pouczenie2", input));
		}
	}
	private class Wersja5 extends Wersja {
		Wersja5(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			TPodmiotDowolnyBezAdresu2 podmiot = new TPodmiotDowolnyBezAdresu2(input, "");
			podmiot.setName("Podmiot1");
			podmiot.getAttributes().put("rola", "P³atnik");
			setPodmiot1(podmiot);
			setPozycjeSzczegolowe(new PozycjeSzczegolowe(input));
			subElements.put("Pouczenie1", new PropertyString("Pouczenie1", input));
			subElements.put("Pouczenie2", new PropertyString("Pouczenie2", input));
			subElements.put("Objasnienie", new PropertyString("Objasnienie", input));
		}
	}
	private class Wersja6 extends Wersja {
		Wersja6(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			TPodmiotDowolnyBezAdresu3 podmiot = new TPodmiotDowolnyBezAdresu3(input);
			podmiot.setName("Podmiot1");
			podmiot.getAttributes().put("rola", "P³atnik");
			setPodmiot1(podmiot);
			setPozycjeSzczegolowe(new PozycjeSzczegolowe(input));
			subElements.put("Pouczenie1", new PropertyString("Pouczenie1", input));
			subElements.put("Pouczenie2", new PropertyString("Pouczenie2", input));
			subElements.put("Objasnienie", new PropertyString("Objasnienie", input));
		}
	}
	
	private class Wersja8 extends Wersja {
		Wersja8(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			TPodmiotDowolnyBezAdresu2 podmiot = new TPodmiotDowolnyBezAdresu2(input, "");
			podmiot.setName("Podmiot1");
			podmiot.getAttributes().put("rola", "P³atnik");
			setPodmiot1(podmiot);
			setPozycjeSzczegolowe(new PozycjeSzczegolowe(input));
			subElements.put("Pouczenia", new Element("Pouczenia", "1"));
		}
	}

}
