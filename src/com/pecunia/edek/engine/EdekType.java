package com.pecunia.edek.engine;

public enum EdekType {
	VAT7("VAT-7"), VAT7K("VAT-7K"), VAT7D("VAT-7D"), VATUE("VAT-UE"), PIT11("PIT-11"), PIT4R("PIT-4R");

	private String name;

	private EdekType(String name) {
		this.name = name;
	}

	public static EdekType forName(String input) {
		String param = input.toUpperCase().trim();
		for (EdekType type : values()) {
			if (type.name.equals(param)) {
				return type;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

}
