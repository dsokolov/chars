package me.ilich.chars;

import java.util.Scanner;

public class Controller {

	private final Scanner keyboard = new Scanner(System.in);
	private final World world;
	private final Inventory inventory;
	private boolean working = true;

	public Controller(World world, Inventory inventory) {
		this.world = world;
		this.inventory = inventory;
	}

	public boolean isWorking() {
		return working;
	}

	public void stop() {
		working = false;
	}

	public void out(String s) {
		System.out.println(s);
	}

	public String in() {
		final String input;
		if (keyboard.hasNextLine()) {
			input = keyboard.nextLine();
		} else {
			input = "";
		}
		return input;
	}

	public World getWorld() {
		return world;
	}

	public Inventory getInventory() {
		return inventory;
	}
}
