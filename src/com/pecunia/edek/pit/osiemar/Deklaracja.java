package com.pecunia.edek.pit.osiemar;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.pecunia.edek.common.Oswiadczenie;
import com.pecunia.edek.common.Pouczenie;
import com.pecunia.edek.common.TDeklaracja;
import com.pecunia.edek.common.TPodmiotDowolny;

public class Deklaracja extends TDeklaracja {

	static List<String> supported = Arrays.asList("3");

	public Deklaracja(Map<String, String> data) {
		super("pit-8ar", supported, data);
		setNaglowek(new TNaglowek(data));
		TPodmiotDowolny podmiot = new TPodmiotDowolny(data, "");
		podmiot.setName("Podmiot1");
		podmiot.getAttributes().put("rola", "P³atnik");//"PÅ‚atnik");
		setPodmiot1(podmiot);
		setPozycjeSzczegolowe(new PozycjeSzczegolowe(data));
		subElements.put("Pouczenie", new Pouczenie(data));
		subElements.put("Oswiadczenie", new Oswiadczenie(data));
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
}
