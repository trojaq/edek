package com.pecunia.edek.common;

import java.util.Collection;
import java.util.Map;

public class TDeklaracja extends Element {

	public TDeklaracja(String type, Collection<String> supportedVer,
			Map<String, String> data) {
		super();
		String dekType = data.get("deklaracja");
		if (dekType == null || !dekType.toLowerCase().equals(type.toLowerCase())) {
			System.out.println("Rodzaj deklaracji w pliku wejsciowym: "
					+ dekType + " jest niezodna z wywolanym parametrem: "
					+ type);
			System.exit(1);
		}
		if (!supportedVer.contains(data.get("wersja"))) {
			System.out.println("Wersja deklaracji w pliku wejsciowym: "
					+ data.get("wersja") + " jest niedozwolona ");
			System.exit(1);
		}
		name = "Deklaracja";
	}
}
