//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.02.18 at 09:58:24 PM CET 
//

package com.pecunia.edek.common;

import java.util.Map;

public class TPodmiotDowolnyBezAdresu2 extends Element {

	public TPodmiotDowolnyBezAdresu2() {
		super();
	}

	public TPodmiotDowolnyBezAdresu2(Map<String, String> data, String sufix) {
		super();
		String of = data.get("RodzajPodatnika");
		if ("1".equals(of)) {
			setOsobaNiefizyczna(new TIdentyfikatorOsobyNiefizycznej(data));
		} else {
			setOsobaFizyczna(new TIdentyfikatorOsobyFizycznej2(data, sufix));
		}
	}

	public void setOsobaFizyczna(TIdentyfikatorOsobyFizycznej2 value) {
		setSub("Osoba", value);
	}

	public void setOsobaNiefizyczna(TIdentyfikatorOsobyNiefizycznej value) {
		setSub("Osoba", value);
	}

}
