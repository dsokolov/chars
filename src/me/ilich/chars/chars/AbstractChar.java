package me.ilich.chars.chars;

import me.ilich.chars.Controller;

public abstract class AbstractChar {

	public void onMapAdded(Controller controller) {

	}

	public abstract String render();

	public abstract String renderInventory();
}
