package com.pecunia.edek.common;

import java.util.HashMap;
import java.util.Map;

public class TRok extends Element {

	private int minimal = 1800;

	private static Map<String, Map<String, Integer>> minRok = new HashMap<String, Map<String, Integer>>();
	static {
		Map<String, Integer> vat7 = new HashMap<String, Integer>();
		vat7.put("10", 2008);
		vat7.put("11", 2010);
		vat7.put("12", 2011);
		vat7.put("14", 2013);
		vat7.put("15", 2015);
		vat7.put("16", 2016);
		vat7.put("17", 2016);
		vat7.put("18", 2018);
		vat7.put("20", 2019);
		minRok.put("vat-7", vat7);
		Map<String, Integer> vat7d = new HashMap<String, Integer>();
		vat7d.put("1", 2009);
		vat7d.put("2", 2010);
		vat7d.put("3", 2011);
		vat7d.put("5", 2013);
		vat7d.put("6", 2015);
		minRok.put("vat-7d", vat7d);
		Map<String, Integer> vat7k = new HashMap<String, Integer>();
		vat7k.put("4", 2008);
		vat7k.put("5", 2010);
		vat7k.put("6", 2011);
		vat7k.put("8", 2013);
		vat7k.put("9", 2015);
		vat7k.put("10", 2016);
		vat7k.put("11", 2016);
		vat7k.put("12", 2018);
		vat7k.put("14", 2019);
		minRok.put("vat-7k", vat7k);
		Map<String, Integer> vatue = new HashMap<String, Integer>();
		vatue.put("1", 2007);
		vatue.put("2", 2011);
		vatue.put("4", 2017);
		minRok.put("vat-ue", vatue);
		Map<String, Integer> pit4r = new HashMap<String, Integer>();
		pit4r.put("3", 2010);
		pit4r.put("3E", 2011);
		pit4r.put("4", 2013);
		pit4r.put("5", 2014);
		pit4r.put("6", 2015);
		pit4r.put("8", 2018);
		minRok.put("pit-4r", pit4r);
		Map<String, Integer> pit11 = new HashMap<String, Integer>();
		pit11.put("19", 2011);
		pit11.put("20", 2013);
		pit11.put("21", 2014);
		pit11.put("23", 2015);
		pit11.put("24", 2018);
		minRok.put("pit-11", pit11);
	}

	
	
	public TRok(Map<String, String> data) {
		name = "Rok";
		setRok(data.get("Rok"));
		Map<String, Integer> map = minRok.get(data.get("deklaracja"));
		minimal = (map != null ? map.get(data.get("wersja")) : minimal);
	}

	public void setRok(String rok) {
		try {
			int rokInt = Integer.parseInt(rok.replace(" ", ""));
			if (rokInt < minimal || rokInt > 3000) {
				System.out.println("Niepoprawny rok:" + rok);
				throw new IllegalArgumentException("Niepoprawny rok");
			}
			value = "" + rokInt;
		} catch (NumberFormatException ex) {
			System.out.println("Niepoprawny format roku:" + rok);
			throw ex;
		}
	}
}
