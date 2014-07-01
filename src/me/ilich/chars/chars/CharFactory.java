package me.ilich.chars.chars;

public class CharFactory {

	public static AbstractChar createFromInput(String input) throws NoSuchCharException {
		final AbstractChar result = null;
		throw new NoSuchCharException(input);
	}

	public static class NoSuchCharException extends Exception {

		private final String input;

		public NoSuchCharException(String input) {
			this.input = input;
		}

		public String getChar() {
			return input;
		}
	}

}
