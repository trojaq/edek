package com.pecunia.edek.vat.ue;

import java.util.Map;

import com.pecunia.edek.common.Element;
import com.pecunia.edek.common.TKodKraju;

public class TDostawy extends Element {

	public TDostawy(int num, Map<String, String> data) {
		super("Grupa1");
		setKodKraju(data.get("D1_" + num), data);
		setNrVat(data.get("D2_" + num));
		setKwota(data.get("D3_" + num));
		setTrojCheck(data.get("D4_" + num));
	}

	public void setKodKraju(String kod, Map<String, String> data) {
		TKodKraju kodKraju = new TKodKraju(kod, data);
		kodKraju.setName("P_Da");
		subElements.put("P_Da", kodKraju);
	}

	public void setNrVat(String nrVat) {
		subElements.put("P_Db", new Element("P_Db", nrVat));
	}

	public void setKwota(String kwota) {
		subElements.put("P_Dc", new Element("P_Dc", kwota));
	}

	public void setTrojCheck(String check) {
		subElements.put("P_Dd", new Element("P_Dd", decodeTrojCheck(check)));
	}

	private String decodeTrojCheck(String check) {
		return (check != null && "1".equals(check)) ? "2" : "1";
	}

}
