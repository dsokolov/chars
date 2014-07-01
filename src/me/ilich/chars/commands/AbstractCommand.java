package me.ilich.chars.commands;

import me.ilich.chars.Controller;

public abstract class AbstractCommand {

	private final Controller controller;

	public AbstractCommand(Controller controller) {
		if (controller == null) {
			throw new NullPointerException("controller");
		}
		this.controller = controller;
	}

	protected Controller getController() {
		return controller;
	}

	public abstract void execute(String s) throws NotSuitableCommandException, CantExecuteCommandExeption;

	/**
	 * Эта комманда не соответсвует вводу
	 */
	public static class NotSuitableCommandException extends Exception {

	}

	public static class CantExecuteCommandExeption extends Exception {

		public CantExecuteCommandExeption(String msg) {
			super(msg);
		}

	}

}
