package me.ilich.chars.commands;

import me.ilich.chars.Controller;
import me.ilich.chars.Inventory;
import me.ilich.chars.World;
import me.ilich.chars.chars.AbstractChar;

public class CharToMapCommand extends AbstractCommand {

	public CharToMapCommand(Controller controller) {
		super(controller);
	}

	@Override
	public void execute(String input) throws NotSuitableCommandException, CantExecuteCommandExeption {
		String[] ss = input.split(" ");
		if (ss.length == 3) {
			String sX = ss[0];
			String sY = ss[1];
			String sC = ss[2];

			int x;
			int y;
			AbstractChar abstractChar;
			try {
				x = getController().getWorld().xFromInput(sX);
			} catch (World.InvalidCoordException e) {
				throw new CantExecuteCommandExeption("invalid x " + sX);
			}
			try {
				y = getController().getWorld().yFromInput(sY);
			} catch (World.InvalidCoordException e) {
				throw new CantExecuteCommandExeption("invalid y " + sY);
			}
			try {
				abstractChar = getController().getInventory().get(sC);
			} catch (Inventory.NotInInventoryException e) {
				throw new CantExecuteCommandExeption("u have no " + e.getChar());
			}
			getController().getWorld().addToMap(getController(), x, y, abstractChar);
		} else {
			throw new NotSuitableCommandException();
		}
	}

}
