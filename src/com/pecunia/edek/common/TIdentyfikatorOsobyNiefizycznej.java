//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.02.18 at 09:58:24 PM CET 
//

package com.pecunia.edek.common;

import java.util.Map;

public class TIdentyfikatorOsobyNiefizycznej extends Element {

	// @XmlElement(name = "NIP", required = true)
	// protected String nip;
	// @XmlElement(name = "PelnaNazwa", required = true)
	// @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	// protected String pelnaNazwa;
	// @XmlElement(name = "REGON")
	// protected String regon;

	public TIdentyfikatorOsobyNiefizycznej() {
		super("OsobaNiefizyczna");
		
		// TODO Auto-generated constructor stub
	}

	public TIdentyfikatorOsobyNiefizycznej(Map<String, String> data, boolean etd) {
		this();
		if(etd) namespace("etd", data);
		setNIP(data.get("NIP"), data, etd);
		setPelnaNazwa(data.get("NazwaPelna"), data, etd);
		setREGON(data.get("REGON"), data, etd);
	}
	
	public TIdentyfikatorOsobyNiefizycznej(Map<String, String> data, boolean etd, boolean outeretd) {
		this();
		if(outeretd) namespace("etd", data);
		setNIP(data.get("NIP"), data, etd);
		setPelnaNazwa(data.get("NazwaPelna"), data, etd);
		setREGON(data.get("REGON"), data, etd);
	}

	public TIdentyfikatorOsobyNiefizycznej(Map<String, String> data) {
		this(data, true);
	}

	public void setNIP(String value, Map<String, String> data, boolean etd) {
		setSub("NIP", new TNrNIP(value, data, etd));
	}

	public void setPelnaNazwa(String value, Map<String, String> data, boolean etd) {
		Element nazwa = new Element("PelnaNazwa", value);
		if(etd) nazwa.namespace("etd", data);
		setSub("PelnaNazwa", nazwa);
	}

	public void setREGON(String value, Map<String, String> data, boolean etd) {
		setSub("REGON", new TNrREGON(value, data, etd));
	}

}