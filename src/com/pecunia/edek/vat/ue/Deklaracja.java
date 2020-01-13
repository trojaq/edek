package com.pecunia.edek.vat.ue;

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

	static List<String> supported = Arrays.asList("1", "2", "4");

	public Deklaracja(Map<String, String> data) {
		super("vat-ue", supported, data);
		if ("4".equals(data.get("wersja"))) {
			setName("Deklaracja "+Globals.getProp("schema", data));
			setEndName("Deklaracja");
			data.put("schemat", "nowy");
		}
		setNaglowek(new TNaglowek(data));
		TPodmiotDowolnyBezAdresu3 podmiot = new TPodmiotDowolnyBezAdresu3(data, "", true, true);
		podmiot.setName("Podmiot1");
		podmiot.getAttributes().put("rola", "Podatnik");
		setPodmiot1(podmiot);
		setPozycjeSzczegolowe(new PozycjeSzczegolowe(data));
		subElements.put("Pouczenie", new Pouczenie(data));
	}

	public void setNaglowek(TNaglowek naglowek) {
		subElements.put("Naglowek", naglowek);
	}

	public void setPodmiot1(TPodmiotDowolnyBezAdresu3 podmiot) {
		subElements.put("Podmiot1", podmiot);
	}

	public void setPozycjeSzczegolowe(PozycjeSzczegolowe pozszczeg) {
		subElements.put("PozycjeSzczegolowe", pozszczeg);
	}


	public TNaglowek getNaglowek() {
		return (TNaglowek) getSub("Naglowek");

	}
}
