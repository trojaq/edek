//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.02.18 at 09:58:24 PM CET 
//

package com.pecunia.edek.common;

import java.util.Map;

public class TPodmiotDowolnyBezAdresu1 extends Element {

	public TPodmiotDowolnyBezAdresu1() {
		super();
	}

	public TPodmiotDowolnyBezAdresu1(Map<String, String> data, String sufix) {
		super();
		String of = data.get("RodzajPodatnika");
		if ("1".equals(of)) {
			setOsobaNiefizyczna(new TIdentyfikatorOsobyNiefizycznej(data));
		} else {
			setOsobaFizyczna(new TIdentyfikatorOsobyFizycznej1(data, sufix));
		}
	}

	public void setOsobaFizyczna(TIdentyfikatorOsobyFizycznej1 value) {
		setSub("Osoba", value);
	}

	public void setOsobaNiefizyczna(TIdentyfikatorOsobyNiefizycznej value) {
		setSub("Osoba", value);
	}

}