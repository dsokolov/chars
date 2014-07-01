package me.ilich.chars.commands;

import me.ilich.chars.Controller;

public class ExitCommand extends AbstractCommand {

	public ExitCommand(Controller controller) {
		super(controller);
	}

	@Override
	public void execute(String s) throws NotSuitableCommandException {
		if ("exit".equalsIgnoreCase(s)) {
			getController().stop();
		} else {
			throw new NotSuitableCommandException();
		}
	}


}
