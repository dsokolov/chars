package me.ilich.chars.chars;

import me.ilich.chars.XY;

public class CharXY {

	private final AbstractChar abstractChar;
	private final XY xy;

	public CharXY(AbstractChar abstractChar, XY xy) {
		this.abstractChar = abstractChar;
		this.xy = xy;
	}

	public AbstractChar getChar() {
		return abstractChar;
	}

	public XY getXY() {
		return xy;
	}
}
