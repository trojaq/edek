package com.pecunia.edek.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class TestCharset {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputStreamReader reader = null;
		try {
			reader = new InputStreamReader(new FileInputStream("test.txt"),
					"ISO-8859-2");
			int ch;
			do {
				ch = reader.read();
				System.out.println(Integer.toHexString(ch));
			} while (ch >= 0);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
