
package com.pecunia.edek.common;

import java.util.Map;

/**
 * Podstawowy zestaw danych o osobie fizycznej
 * 
 * <p>
 * Java class for TOsobaFizyczna complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;TOsobaFizyczna&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;OsobaFizyczna&quot; type=&quot;{}TIdentyfikatorOsobyFizycznej&quot;/&gt;
 *         &lt;element name=&quot;AdresZamieszkania&quot;&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base=&quot;{}TAdres&quot;&gt;
 *                 &lt;attribute name=&quot;rodzajAdresu&quot; use=&quot;required&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; fixed=&quot;RAD&quot; /&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
public class TOsobaFizyczna extends Element {

	public TOsobaFizyczna(Map<String, String> data, String name, String sufix) {
		super(name);
		setOsobaFizyczna(new TIdentyfikatorOsobyFizycznej(data, sufix));
		TAdres tAdres = new TAdres("AdresZamieszkania", data, sufix);
		tAdres.getAttributes().put("rodzajAdresu", "RAD");
		setAdres(tAdres);
	}

	public void setAdres(TAdres tAdres) {
		setSub("AdresZamieszkania", tAdres);
	}

	public void setOsobaFizyczna(TIdentyfikatorOsobyFizycznej value) {
		setSub("OsobaFizyczna", value);
	}

}
