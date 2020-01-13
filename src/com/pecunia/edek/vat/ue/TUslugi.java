package com.pecunia.edek.vat.ue;

import java.util.Map;

import com.pecunia.edek.common.Element;
import com.pecunia.edek.common.TKodKraju;

public class TUslugi extends Element {

	public TUslugi(int num, Map<String, String> data) {
		super("Grupa3");
		setKodKraju(data.get("U1_" + num), data);
		setNrVat(data.get("U2_" + num));
		setKwota(data.get("U3_" + num));
	}

	public void setKodKraju(String kod, Map<String, String> data) {
		TKodKraju kodKraju = new TKodKraju(kod, data);
		kodKraju.setName("P_Ua");
		subElements.put("P_Ua", kodKraju);
	}

	public void setNrVat(String nrVat) {
		subElements.put("P_Ub", new Element("P_Ub", nrVat));
	}

	public void setKwota(String kwota) {
		subElements.put("P_Uc", new Element("P_Uc", kwota));
	}

}
