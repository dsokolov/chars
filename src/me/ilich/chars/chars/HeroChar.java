package me.ilich.chars.chars;

import me.ilich.chars.Controller;

public class HeroChar extends AbstractChar {

	@Override
	public void onMapAdded(Controller controller) {
		controller.getInventory().put(new BoneChar(), 2);
	}

	@Override
	public String render() {
		return "@";
	}

	@Override
	public String renderInventory() {
		return "@";
	}
}
