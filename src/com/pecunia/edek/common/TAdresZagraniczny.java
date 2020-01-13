package com.pecunia.edek.common;

import java.util.Map;

public class TAdresZagraniczny extends TAdresBase {

	public TAdresZagraniczny() {
		super("AdresZagr");
	}

	public TAdresZagraniczny(String name) {
		super(name);
	}

	public TAdresZagraniczny(Map<String, String> data, String sufix) {
		super("AdresZagr");
		namespace("etd", data);
		setKodKraju(data.get("Kraj" + sufix), data);
		setKodPocztowy(data.get("KodPocztowy" + sufix), data);
		setMiejscowosc(data.get("Miejscowosc" + sufix), data);
		setUlica(data.get("Ulica" + sufix), data);
		setNrDomu(data.get("NrDomu" + sufix), data);
		setNrLokalu(data.get("NrLokalu" + sufix), data);
	}

}
