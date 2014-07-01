package me.ilich.chars;

public class XY {

	private final int x;
	private final int y;

	public XY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return x * 100 + y;
	}

	@Override
	public boolean equals(Object obj) {
		final boolean result;
		if (obj instanceof XY) {
			XY xy = (XY) obj;
			result = this.x == xy.x && this.y == xy.y;
		} else {
			result = false;
		}
		return result;
	}

	@Override
	public String toString() {
		return "XY (" + x + ", " + y + ")";
	}
}
