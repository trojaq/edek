package com.pecunia.edek.common;

import java.util.SortedMap;
import java.util.TreeMap;

public abstract class TPozycjeSzczegoloweSorted extends TPozycjeSzczegoloweUnsorted {

	private boolean unsorted = false;
	
	public TPozycjeSzczegoloweSorted() {
		super();
	}
	
	public void setUnsorted() {
		unsorted = true;
	}

	@Override
	protected void writeSubElements(StringBuilder builder, int indent) {
		if(unsorted) {
			super.writeSubElements(builder, indent);
		} else {
			SortedMap<String, Element> sorted = new TreeMap<String, Element>(
					subElements);
			for (String key : sorted.keySet()) {
				sorted.get(key).writeElement(builder, indent + 1);
			}
		}
	}

}
