package me.ilich.chars.commands;

import me.ilich.chars.Controller;

public class HelpCommand extends AbstractCommand {

	public HelpCommand(Controller controller) {
		super(controller);
	}

	@Override
	public void execute(String s) throws NotSuitableCommandException {
		if ("?".equalsIgnoreCase(s)) {
			getController().out("help message here");
		} else {
			throw new NotSuitableCommandException();
		}
	}
}
