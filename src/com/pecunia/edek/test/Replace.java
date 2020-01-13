package com.pecunia.edek.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
//			BufferedReader read = new BufferedReader(new FileReader(
//					"TKodKraju.java"));
//			String line = read.readLine();
//			StringBuilder build = new StringBuilder();
//			while (line != null) {
//				build.append(line).append("\r\n");
//				line = read.readLine();
//			}
//			Pattern pat = Pattern.compile("/\\*\\*[\\s]*\\* ([\\S ]*)[\\s]*\\*[\\s]*\\*/[\\s]*([^,][^,])");//[\\w]*\\*/");
//			Matcher match = pat.matcher(build.toString());
//			System.out.println(match.replaceAll("$2(\\\"$1\\\",\\\"$2\\\")"));
			
			String string = "  Test   me \n whitespace    a  a ";
			System.out.println(string);
			System.out.println(string.trim().replaceAll("\\s+", " "));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
