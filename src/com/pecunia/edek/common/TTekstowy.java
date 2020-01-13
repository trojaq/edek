package com.pecunia.edek.common;

import java.util.Map;

public abstract class TTekstowy {
	public static String getTekst(Map<String, String> input,int field) {
		int j = 1;
		StringBuilder builder = new StringBuilder(); 
		while(input.containsKey("T" + j + "_" + field)) {
			builder.append(input.get("T" + j + "_" + field)).append("\r\n");
			j++;
		}
		String result = builder.toString();
		if (result.trim().length() == 0) {
			return null;
		}
		return result;
	}
}
