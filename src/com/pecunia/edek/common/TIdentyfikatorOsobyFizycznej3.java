//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.02.18 at 09:58:24 PM CET 
//

package com.pecunia.edek.common;

import java.util.Map;

public class TIdentyfikatorOsobyFizycznej3 extends Element {

	// @XmlElement(name = "NIP", required = true)
	// protected String nip;
	// @XmlElement(name = "ImiePierwsze", required = true)
	// @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	// protected String imiePierwsze;
	// @XmlElement(name = "Nazwisko", required = true)
	// @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	// protected String nazwisko;
	// @XmlElement(name = "DataUrodzenia", required = true)
	// protected XMLGregorianCalendar dataUrodzenia;
	// @XmlElement(name = "PESEL")
	// protected String pesel;

	public TIdentyfikatorOsobyFizycznej3() {
		super("OsobaFizyczna");
		// TODO Auto-generated constructor stub
	}

	public TIdentyfikatorOsobyFizycznej3(Map<String, String> data, String sufix) {
		this();
		setNIP(data.get("NIP" + sufix), data, false);
		setImiePierwsze(data.get("Imie" + sufix), data, false);
		setNazwisko(data.get("Nazwisko" + sufix), data, false);
		setDataUrodzenia(parseDate(data.get("DataUrodzenia" + sufix)), data, false);
	}

	public TIdentyfikatorOsobyFizycznej3(Map<String, String> data, String sufix, boolean etd, boolean outeretd) {
		this();
		if(outeretd) namespace("etd", data);
		setNIP(data.get("NIP" + sufix), data, etd);
		setImiePierwsze(data.get("Imie" + sufix), data, etd);
		setNazwisko(data.get("Nazwisko" + sufix), data, etd);
		setDataUrodzenia(parseDate(data.get("DataUrodzenia" + sufix)), data, etd);
	}

	public void setNIP(String value, Map<String, String> data, boolean etd) {
		setSub("NIP", new TNrNIP(value, data, etd));
	}

	public void setImiePierwsze(String value, Map<String, String> data, boolean etd) {
		setSub("Imie", new TImie("ImiePierwsze", value, data, etd));
	}

	public void setNazwisko(String value, Map<String, String> data, boolean etd) {
		setSub("Nazwisko", new TNazwisko(value, data, etd));
	}

	public void setDataUrodzenia(String date, Map<String, String> data, boolean etd) {
		setSub("DataUrodzenia", new TDate("DataUrodzenia", date, data, etd));
	}


}
