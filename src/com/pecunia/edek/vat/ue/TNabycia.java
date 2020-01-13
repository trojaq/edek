package com.pecunia.edek.vat.ue;

import java.util.Map;

import com.pecunia.edek.common.Element;
import com.pecunia.edek.common.TKodKraju;

public class TNabycia extends Element {

	public TNabycia(int num, Map<String, String> data) {
		super("Grupa2");
		setKodKraju(data.get("N1_" + num), data);
		setNrVat(data.get("N2_" + num));
		setKwota(data.get("N3_" + num));
		setTrojCheck(data.get("N4_" + num));
	}

	public void setKodKraju(String kod, Map<String, String> data) {
		TKodKraju kodKraju = new TKodKraju(kod, data);
		kodKraju.setName("P_Na");
		subElements.put("P_Na", kodKraju);
	}

	public void setNrVat(String nrVat) {
		subElements.put("P_Nb", new Element("P_Nb", nrVat));
	}

	public void setKwota(String kwota) {
		subElements.put("P_Nc", new Element("P_Nc", kwota));
	}

	public void setTrojCheck(String check) {
		subElements.put("P_Nd", new Element("P_Nd", decodeTrojCheck(check)));
	}

	private String decodeTrojCheck(String check) {
		return (check != null && "1".equals(check)) ? "2" : "1";
	}


}
