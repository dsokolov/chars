package me.ilich.chars;

import me.ilich.chars.chars.HeroChar;
import me.ilich.chars.commands.AbstractCommand;
import me.ilich.chars.commands.CharToMapCommand;
import me.ilich.chars.commands.ExitCommand;
import me.ilich.chars.commands.HelpCommand;

import java.util.ArrayList;
import java.util.List;

public class CharsApp {

	private World world = new World(8, 8);
	private Inventory inventory = new Inventory();
	private List<AbstractCommand> commands = new ArrayList<AbstractCommand>();
	private int step = 0;
	private Controller controller = new Controller(world, inventory);

	public CharsApp() {
		commands.add(new HelpCommand(controller));
		commands.add(new ExitCommand(controller));
		commands.add(new CharToMapCommand(controller));
		inventory.put(new HeroChar());
	}

	public static void main(String[] args) {
		CharsApp app = new CharsApp();
		app.start();
	}

	private void start() {
		controller.out("*** C.H.A.R.S. ***");
		while (controller.isWorking()) {
			render();
			processInput();
			step++;
		}
		controller.out("bye-bye");
	}

	private void processInput() {
		String input = controller.in();
		for (AbstractCommand command : commands) {
			try {
				command.execute(input);
				break;
			} catch (AbstractCommand.NotSuitableCommandException e) {
			} catch (AbstractCommand.CantExecuteCommandExeption e) {
				controller.out(e.getMessage());
			}
		}
	}

	private void render() {
		StringBuilder sb = new StringBuilder();
		sb.append(Constants.NEW_LINE);
		sb.append("#" + step);
		sb.append(Constants.NEW_LINE);
		sb.append(world.render());
		sb.append(inventory.render());
		controller.out(sb.toString());
	}
}
