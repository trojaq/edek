package com.pecunia.edek.pit.jedenascie;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.pecunia.edek.common.Element;
import com.pecunia.edek.common.Globals;
import com.pecunia.edek.common.Pouczenie;
import com.pecunia.edek.common.TAdresZamieszkaniaSiedziby;
import com.pecunia.edek.common.TDeklaracja;
import com.pecunia.edek.common.TOsobaFizyczna;
import com.pecunia.edek.common.TOsobaFizyczna1;
import com.pecunia.edek.common.TOsobaFizyczna1FlatAdres;
import com.pecunia.edek.common.TOsobaFizyczna4FlatAdres;
import com.pecunia.edek.common.TPodmiotDowolny;
import com.pecunia.edek.common.TPodmiotDowolnyBezAdresu2;
import com.pecunia.edek.common.TPodmiotDowolnyBezAdresu3;


public class Deklaracja extends TDeklaracja {

	static List<String> supported = Arrays.asList("17", "19", "20","21", "23", "24");

	public Deklaracja(Map<String, String> data) {
		super("pit-11", supported, data);
		newSchemaName("Deklaracja "+Globals.getProp("schema", data), data);
//		newSchemaName(
//				"Deklaracja xsi:schemaLocation=\"http://"+Globals.getProp("schemaLocation", data)+"/ http://"+Globals.getProp("schemaWzor",data)+"\" xmlns=\"http://"+Globals.getProp("xmlns",data)+"/\" xmlns:etd=\"http://"+Globals.getProp("xmlns_edt",data)+"/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"",
//				data);
		setEndName("Deklaracja");
		wersje.put("17", new Wersja17(data));
		wersje.put("19", new Wersja19(data));
		wersje.put("20", new Wersja20(data));
		wersje.put("21", new Wersja21(data));
		wersje.put("23", new Wersja23(data));
		wersje.put("24", new Wersja24(data));
		setNaglowek(new TNaglowek(data));
		wypelnij(data.get("wersja"));
	}

	public void setNaglowek(TNaglowek naglowek) {
		subElements.put("Naglowek", naglowek);
	}

	public void setPodmiot1(Element podmiot) {
		subElements.put("Podmiot1", podmiot);
	}

	public void setPodmiot2(Element podmiot) {
		subElements.put("Podmiot2", podmiot);
	}

	public void setPozycjeSzczegolowe(PozycjeSzczegolowe pozszczeg) {
		subElements.put("PozycjeSzczegolowe", pozszczeg);
	}

	public TNaglowek getNaglowek() {
		return (TNaglowek) getSub("Naglowek");
	}

	private class Wersja17 extends Wersja {
		Wersja17(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			TPodmiotDowolny podmiot = new TPodmiotDowolny(input, "");
			podmiot.setName("Podmiot1");
			podmiot.getAttributes().put("rola", "P³atnik");
			setPodmiot1(podmiot);
			TOsobaFizyczna podmiot2 = new TOsobaFizyczna(input, "Podmiot2",
					"_2");
			podmiot2.getAttributes().put("rola", "Podatnik");
			setPodmiot2(podmiot2);
			setPozycjeSzczegolowe(new PozycjeSzczegolowe(input));
			subElements.put("Pouczenie", new Pouczenie(input));
		}
	}

	private class Wersja19 extends Wersja {
		Wersja19(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			TPodmiotDowolnyBezAdresu2 podmiot = new TPodmiotDowolnyBezAdresu2(
					input, "");
			podmiot.setName("Podmiot1");
			podmiot.getAttributes().put("rola", "P³atnik");
			podmiot.setSub("AdresZamieszkaniaSiedziby",
					new TAdresZamieszkaniaSiedziby(input));
			setPodmiot1(podmiot);
			TOsobaFizyczna1 podmiot2 = new TOsobaFizyczna1(input, "Podmiot2",
					"_2");
			podmiot2.getAttributes().put("rola", "Podatnik");
			podmiot2.getAttributes().put("poz", "P_20A");
			setPodmiot2(podmiot2);
			setPozycjeSzczegolowe(new PozycjeSzczegolowe(input));
			subElements.put("Pouczenie", new Pouczenie(input));
		
		}
	}
	private class Wersja20 extends Wersja {
		Wersja20(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			TPodmiotDowolnyBezAdresu2 podmiot = new TPodmiotDowolnyBezAdresu2(
					input, "");
			podmiot.setName("Podmiot1");
			podmiot.getAttributes().put("rola", "P³atnik");
			setPodmiot1(podmiot);
			TOsobaFizyczna1 podmiot2 = new TOsobaFizyczna1(input, "Podmiot2",
					"_2");
			podmiot2.getAttributes().put("rola", "Podatnik");
			podmiot2.getAttributes().put("poz", "P_10A");
			setPodmiot2(podmiot2);
			setPozycjeSzczegolowe(new PozycjeSzczegolowe(input));
			subElements.put("Pouczenie", new Pouczenie(input));
			
		}
	}
	private class Wersja21 extends Wersja {
		Wersja21(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			TPodmiotDowolnyBezAdresu2 podmiot = new TPodmiotDowolnyBezAdresu2(
					input, "");
			podmiot.setName("Podmiot1");
			podmiot.getAttributes().put("rola", "P³atnik");
			setPodmiot1(podmiot);
			TOsobaFizyczna1 podmiot2 = new TOsobaFizyczna1(input, "Podmiot2",
					"_2");
			podmiot2.getAttributes().put("rola", "Podatnik");
			setPodmiot2(podmiot2);
			setPozycjeSzczegolowe(new PozycjeSzczegolowe(input));
			subElements.put("Pouczenie", new Pouczenie(input));
			
		}
	}
	private class Wersja23 extends Wersja {
		Wersja23(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			TPodmiotDowolnyBezAdresu3 podmiot = new TPodmiotDowolnyBezAdresu3(
					input);
			podmiot.setName("Podmiot1");
			podmiot.getAttributes().put("rola", "P³atnik");
			setPodmiot1(podmiot);
			input.put("noetd", "true");
			TOsobaFizyczna1FlatAdres podmiot2 = new TOsobaFizyczna1FlatAdres(input, "Podmiot2",
					"_2");
			podmiot2.getAttributes().put("rola", "Podatnik");
			setPodmiot2(podmiot2);
			setPozycjeSzczegolowe(new PozycjeSzczegolowe(input));
			subElements.put("Pouczenie", new Pouczenie(input));
			
		}
	}
	private class Wersja24 extends Wersja {
		Wersja24(Map<String, String> input) {
			super(input);
		}

		protected void fill() {
			TPodmiotDowolnyBezAdresu3 podmiot = new TPodmiotDowolnyBezAdresu3(
					input, "", true, true);
			podmiot.setName("Podmiot1");
			podmiot.getAttributes().put("rola", "P³atnik/Sk³adaj¹cy");
			setPodmiot1(podmiot);
//			input.put("noetd", "true");
			TOsobaFizyczna4FlatAdres podmiot2 = new TOsobaFizyczna4FlatAdres(input, "Podmiot2",
					"_2", true, false);
			podmiot2.getAttributes().put("rola", "Podatnik");
			setPodmiot2(podmiot2);
			setPozycjeSzczegolowe(new PozycjeSzczegolowe(input));
			subElements.put("Pouczenia", new Element("Pouczenie", "1"));

		}
	}
}
