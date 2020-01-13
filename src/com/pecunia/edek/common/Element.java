package com.pecunia.edek.common;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Element {

	public abstract class Wersja {
		protected Map<String, String> input;

		public Wersja(Map<String, String> input) {
			this.input = input;
		}

		abstract protected void fill();
		public void pouczenia() {}
	}

	public Element() {
	}

	public Element(String name) {
		setName(name);
	}

	public Element(String name, String value) {
		setName(name);
		this.value = value;
	}

	protected String name;
	protected String endName;
	protected LinkedHashMap<String, String> attributes = new LinkedHashMap<String, String>();
	protected LinkedHashMap<String, Element> subElements = new LinkedHashMap<String, Element>();
	protected String value;
	protected Map<String, Wersja> wersje = new HashMap<String, Wersja>();

	public String getValue() {
		return value;
	}

	private void indentiate(StringBuilder builder, int indent) {
		for (int i = 0; i < indent; i++)
			builder.append(Globals.INDENT);
	}

	public void writeElement(StringBuilder builder, int indent) {
		indentiate(builder, indent);
		builder.append("<").append(name);
		if (attributes.size() > 0) {
			for (Entry<String, String> entry : attributes.entrySet()) {
				builder.append(" ").append(entry.getKey()).append("=\"")
						.append(entry.getValue()).append("\"");
			}
		}
		if (value != null || subElements.size() > 0) {
			builder.append(">");
			if (subElements.size() > 0) {
				builder.append("\r\n");
			}
			writeSubElements(builder, indent);
			if (value != null) {
				if (subElements.size() > 0) {
					indentiate(builder, indent);
				}
				builder.append(value);
				if (subElements.size() > 0) {
					builder.append("\r\n");
				}
			}
			if (subElements.size() > 0) {
				indentiate(builder, indent);
			}
			builder.append("</").append(endName != null? endName : name).append(">");
		} else {
			builder.append(" />");
		}
		builder.append("\r\n");
	}

	protected void writeSubElements(StringBuilder builder, int indent) {
		for (String key : subElements.keySet()) {
			System.out.println("Writing " + key);
			subElements.get(key).writeElement(builder, indent + 1);
		}
	}

	protected void newSchemaName(String name, Map<String, String> data) {
		if("nowy".equals(data.get("schemat"))) {
			setName(name);
		}
	}
	protected void namespace(String namespace, Map<String, String> data) {
		if("nowy".equals(data.get("schemat"))) {
			if(!data.containsKey("no" + namespace)) {
				setName(namespace + ":" + name);
			}
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setEndName(String name) {
		this.endName = name;
	}

	public LinkedHashMap<String, String> getAttributes() {
		return attributes;
	}

	public LinkedHashMap<String, Element> getSubElements() {
		return subElements;
	}

	public void setSub(String key, Element value) {
		subElements.put(key, value);
	}

	public Element getSub(String key) {
		return subElements.get(key);
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int decodeEnumInt(String string) {
		// return "T".equals(string) ? 1 : 2;
		return Integer.parseInt(string);
	}

	public int decodeReverseInt(String string) {
		int val = Integer.parseInt(string);
		return val == 1 ? 2 : 1;
	}

	public String parseDate(String string) {
		// String[] split = string.split("-");
		// return split[2] + "-" + split[1] + "-" + split[0];
		return string;
	}

	public boolean exists(String value) {
		return value != null && !"".equals(value);
	}

	protected void wypelnij(String wersja) {
		if (wersje.containsKey(wersja)) {
			wersje.get(wersja).fill();
		}
	}

}
