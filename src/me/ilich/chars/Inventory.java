package me.ilich.chars;

import me.ilich.chars.chars.AbstractChar;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	private List<AbstractChar> chars = new ArrayList<AbstractChar>();

	public String render() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		boolean isFirst = true;
		for (AbstractChar abstractChar : chars) {
			String s = abstractChar.renderInventory();
			sb.append(s);
			if (isFirst) {
				isFirst = false;
			} else {
				sb.append(", ");
			}
		}
		sb.append("]");
		sb.append(Constants.NEW_LINE);
		return sb.toString();
	}

	public boolean has(String s) {
		final boolean result;
		result = false;
		return result;
	}

	public void put(AbstractChar abstractChar) {
		chars.add(abstractChar);
	}

	public void put(AbstractChar abstractChar, int count) {
		for (int i = 0; i < count; i++) {
			chars.add(abstractChar);
		}
	}

	public AbstractChar get(String sC) throws NotInInventoryException {
		AbstractChar result = null;
		int removeIndex = -1;
		for (int i = 0; i < chars.size(); i++) {
			AbstractChar abstractChar = chars.get(i);
			if (abstractChar.renderInventory().equals(sC)) {
				result = abstractChar;
				removeIndex = i;
				break;
			}
		}
		if (result == null) {
			throw new NotInInventoryException(sC);
		} else {
			chars.remove(removeIndex);
		}
		return result;
	}

	public static class NotInInventoryException extends Exception {

		private final String input;

		public NotInInventoryException(String input) {
			this.input = input;
		}

		public String getChar() {
			return input;
		}

	}

}
