import controller.CommandHandler;
import controller.ElementInputHandler;
import controller.commands.*;
import service.*;
import ui.*;

public class Main {
    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        collectionManager.loadCollection("collection.csv");
        CommandHandler commandHandler = new CommandHandler();
        ElementInputHandler inputHandler = new ElementInputHandler();

        commandHandler.register(new ExitCommand());
        commandHandler.register(new AddCommand(collectionManager, inputHandler));
        commandHandler.register(new InfoCommand(collectionManager));
        commandHandler.register(new ShowCommand(collectionManager));
        commandHandler.register(new UpdateCommand(collectionManager, inputHandler));
        commandHandler.register(new ClearCommand(collectionManager));
        commandHandler.register(new RemoveByIdCommand(collectionManager));
        commandHandler.register(new SaveCommand(collectionManager));
        commandHandler.register(new ExecuteScriptCommand(commandHandler));
        commandHandler.register(new AddIfMinCommand(collectionManager, inputHandler));
        commandHandler.register(new RemoveGreaterCommand(collectionManager, inputHandler));
        commandHandler.register(new RemoveLowerCommand(collectionManager, inputHandler));
        commandHandler.register(new CountGreaterThanTypeCommand(collectionManager));
        commandHandler.register(new FilterByRefundableCommand(collectionManager));
        commandHandler.register(new FilterGreaterThanPersonCommand(collectionManager));
        commandHandler.register(new HelpCommand(commandHandler));

        ConsoleUI consoleUI = new ConsoleUI(commandHandler);
        consoleUI.startInteractiveMode();
    }
}
