//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.02.18 at 09:58:24 PM CET 
//

package com.pecunia.edek.common;

import java.util.Map;

public class TPodmiotDowolny extends TPodmiotDowolnyBezAdresu {

	public TPodmiotDowolny() {
		super();
	}

	public TPodmiotDowolny(Map<String, String> data, String sufix) {
		super(data, sufix);
		setAdresZamieszkaniaSiedziby(new TAdresZamieszkaniaSiedziby(data));
	}

	public void setAdresZamieszkaniaSiedziby(TAdresZamieszkaniaSiedziby value) {
		setSub("AdresZamieszkaniaSiedziby", value);
	}

}
