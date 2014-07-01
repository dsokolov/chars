package me.ilich.chars;

import me.ilich.chars.chars.AbstractChar;
import me.ilich.chars.chars.CharXY;
import me.ilich.chars.chars.GroundChar;

import java.util.HashMap;

public class World {

	private final int sizeX;
	private final int sizeY;
	private HashMap<XY, CharXY> chars = new HashMap<XY, CharXY>();

	public World(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		for (int y = 0; y < sizeY; y++) {
			for (int x = 0; x < sizeX; x++) {
				final XY xy = new XY(x, y);
				final AbstractChar abstractChar = new GroundChar();
				final CharXY charXY = new CharXY(abstractChar, xy);
				chars.put(charXY.getXY(), charXY);
			}
		}
	}

	public String render() {
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < sizeY + 1; y++) {
			for (int x = 0; x < sizeX + 1; x++) {
				final String s;
				if (x == 0 && y == 0) {
					s = " ";
				} else if (x == 0 && y != 0) {
					s = Constants.MARKS_Y[y - 1];
				} else if (x != 0 && y == 0) {
					s = Constants.MARKS_X[x - 1];
				} else {
					XY xy = new XY(x - 1, y - 1);
					CharXY charXY = chars.get(xy);
					AbstractChar abstractChar = charXY.getChar();
					s = abstractChar.render();
				}
				if (s != null) {
					sb.append(s);
				}
			}
			sb.append(Constants.NEW_LINE);
		}
		return sb.toString();
	}

	public boolean validateX(String x) {
		boolean result = false;
		for (int i = 0; i < sizeX; i++) {
			String s = Constants.MARKS_X[i];
			if (x.equalsIgnoreCase(s)) {
				result = true;
				break;
			}
		}
		return result;
	}

	public boolean validateY(String y) {
		boolean result = false;
		for (int i = 0; i < sizeY; i++) {
			String s = Constants.MARKS_Y[i];
			if (y.equalsIgnoreCase(s)) {
				result = true;
				break;
			}
		}
		return result;
	}

	private int getXindex(String x) {
		int result = -1;
		for (int i = 0; i < sizeX; i++) {
			String s = Constants.MARKS_X[i];
			if (s.equalsIgnoreCase(x)) {
				result = i;
				break;
			}
		}
		return result;
	}

	private int getYindex(String y) {
		int result = -1;
		for (int i = 0; i < sizeY; i++) {
			String s = Constants.MARKS_Y[i];
			if (s.equalsIgnoreCase(y)) {
				result = i;
				break;
			}
		}
		return result;
	}

	public void addToMap(Controller controller, int x, int y, AbstractChar abstractChar) {
		XY xy = new XY(x, y);
		CharXY charXY = new CharXY(abstractChar, xy);
		chars.put(charXY.getXY(), charXY);
		charXY.getChar().onMapAdded(controller);
	}

	public int xFromInput(String sX) throws InvalidCoordException {
		int result = getXindex(sX);
		if (result == -1) {
			throw new InvalidCoordException();
		} else {
			return result;
		}
	}

	public int yFromInput(String sY) throws InvalidCoordException {
		int result = getYindex(sY);
		if (result == -1) {
			throw new InvalidCoordException();
		} else {
			return result;
		}
	}

	public static class InvalidCoordException extends Exception {

	}
}
