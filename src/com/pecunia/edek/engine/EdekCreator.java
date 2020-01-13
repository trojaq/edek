package com.pecunia.edek.engine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.pecunia.edek.common.Element;

public class EdekCreator {

	private static final String VERSION = "E-Dek Creator v.1.9";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			if (args.length == 1 && "-v".equals(args[0].toLowerCase())) {
				System.out.println(VERSION);
				return;
			}
			if (args.length < 3) {
				System.out.println("Zla liczba argumentow!");
				System.out.println("Wlasciwe uzycie:");
				System.out
						.println("edek typ_deklaracji plik_wejciowy plik_wyjsciowy [kodowanie]");
				System.out.println("Kodowanie:");
				System.out.println("1 (default) - UTF-8");
				System.out.println("2 - ISO-8859-2");

				// System.out.println("edek typ_deklaracji katalog");
				return;
			}
			EdekType typ = EdekType.forName(args[0]);
			if (typ == null) {
				System.out.println("Niewlasciwy typ dokumentu!");
				System.out.println("Dostepne typy:");
				for (EdekType typ2 : EdekType.values()) {
					System.out.println(typ2.getName());
				}
				return;
			}
			if (args.length >= 3) {
				String inputFile = args[1];
				if (!new File(inputFile).exists()) {
					System.out.println("Plik " + inputFile + "nie istnieje!");
					return;
				}
				String output = args[2];

				createDek(typ, inputFile, output, (args.length > 3 && "2"
						.equals(args[3])) ? "ISO-8859-2" : "UTF-8");
			}
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	private static void createDek(EdekType typ, String inputFile,
			String output, String encoding) throws Exception {
		Element dek = new EdekFactory().getDek(typ, inputFile);

		StringBuilder builder = new StringBuilder(
				"<?xml version=\"1.0\" encoding=\"" + encoding.toLowerCase()
						+ "\"?>\r\n");
		dek.writeElement(builder, 0);
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(output), encoding));
			writer.write(builder.toString());
			writer.flush();
			writer.close();
		} catch (IOException e1) {
			System.out.println("Problem z zapisem do pliku " + output);
			System.out.println("Wyjatek : " + e1.getMessage());
			System.out.println("Tresc deklaracji:");
			System.out.println(builder);
			throw e1;
		}
	}

}
