package com.pecunia.edek.engine;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.pecunia.edek.common.Element;

public class EdekFactory {

	public Element getVat7(String file) {
		return new com.pecunia.edek.vat.siedem.Deklaracja(getFilledData(file,
				"/vat7-#.map"));
	}

	public Element getVat7D(String file) {
		return new com.pecunia.edek.vat.siedem.d.Deklaracja(getFilledData(file,
				"/vat7d-#.map"));
	}

	public Element getVat7K(String file) {
		return new com.pecunia.edek.vat.siedem.k.Deklaracja(getFilledData(file,
				"/vat7k-#.map"));
	}

	public Element getVatUE(String file) {
		return new com.pecunia.edek.vat.ue.Deklaracja(getFilledData(file,
				"/vatue-#.map"));
	}

	public Element getPit11(String file) {
		return new com.pecunia.edek.pit.jedenascie.Deklaracja(getFilledData(
				file, "/pit11-#.map"));
	}

	public Element getPit4r(String file) {
		return new com.pecunia.edek.pit.czteryr.Deklaracja(getFilledData(file,
				"/pit4r-#.map"));
	}

	private Map<String, String> getFilledData(String fileName, String mapFile) {
		Map<String, String> input = readData(fileName, false);
		String wersja = input.get("wersja");
		Map<String, String> mapping = readData(mapFile.replace("#", wersja),
				true);
		Map<String, String> data = new HashMap<String, String>();
		Set<String> inputKeys = new HashSet<String>(input.keySet());
		for (String mapKey : mapping.keySet()) {
			String inputData = input.get(mapping.get(mapKey));
			if (inputData != null) {
				inputData = inputData.trim().replaceAll("\\s+", " ");
			}
			if (inputData != null && inputData.endsWith(".00")) {
				inputData = inputData.substring(0, inputData.length() - 3);
			}
			if (inputData != null) {
				data.put(mapKey, inputData);
			}
			inputKeys.remove(mapping.get(mapKey));
		}
		for (String key : inputKeys) {
			String value = input.get(key);
			if (value != null) {
				value = value.trim().replaceAll("\\s+", " ");
			}
			if (value != null && value.endsWith(".00")) {
				value = value.substring(0, value.length() - 3);
			}
			data.put(key, value);
		}
		return data;
	}

	private Map<String, String> readData(String file, boolean resource) {
		BufferedReader reader = null;
		Map<String, String> data = new HashMap<String, String>();
		try {
			reader = new BufferedReader(new InputStreamReader(
					resource ? getClass().getResourceAsStream(file)
							: new FileInputStream(file), "ISO-8859-2"));
			String line;
			do {
				line = reader.readLine();
				if (line == null) {
					break;
				}
				if (line.startsWith("*")) {
					continue;
				}
				String[] split = line.split(":=");
				if (split.length != 2) {
					continue;
				}
				data.put(split[0], split[1]);
			} while (true);
		} catch (Exception e) {
			e.printStackTrace();
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return data;
	}

	public Element getDek(EdekType typ, String file) {
		switch (typ) {
		case VAT7:
			return getVat7(file);
		case VAT7D:
			return getVat7D(file);
		case VAT7K:
			return getVat7K(file);
		case VATUE:
			return getVatUE(file);
		case PIT11:
			return getPit11(file);
		case PIT4R:
			return getPit4r(file);
		default:
			return null;
		}
	}

}
