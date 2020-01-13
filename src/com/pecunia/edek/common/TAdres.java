package com.pecunia.edek.common;

import java.util.Map;

public class TAdres extends Element {

	public TAdres(String name) {
		this.name = name;
	}

	public TAdres(String name, Map<String, String> data, String sufix) {
		this(name);
		namespace("etd", data);
		TKodKraju kod = new TKodKraju(data.get("Kraj" + sufix), data);
		if ("PL".equals(kod.getValue())) {
			setAdres(new TAdresPolski(data, sufix));
		} else {
			setAdres(new TAdresZagraniczny(data, sufix));
		}
	}
	public void setAdres(TAdresBase adres) {
		setSub("Adres", adres);
	}

	public TAdresBase getAdres() {
		return (TAdresBase) getSub("Adres");
	}

}
