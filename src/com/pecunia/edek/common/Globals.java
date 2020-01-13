package com.pecunia.edek.common;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class Globals {

	public static Properties props = new Properties();
	public static final String INDENT = "   ";

	static {
		InputStream props1;
		try {
			props1 = Globals.class.getResourceAsStream("/decoded.properties");
			props.load(props1);
			props1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProp(String name, Map<String, String> data) {
		return props.getProperty(data.get("deklaracja").toLowerCase() + "-" + data.get("wersja") +"." + name);
	}
}
