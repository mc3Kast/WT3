package task.server.command;

import task.server.command.exception.CommandException;
import task.server.command.impl.*;

public class CommandProvider {
    private static final CommandProvider INSTANCE = new CommandProvider();

    private CommandProvider() {
    }

    public static CommandProvider getInstance() {
        return INSTANCE;
    }

    public Command getCommand(String request) throws CommandException {
        if (request == null) throw new CommandException("No command");
        var arguments = request.split(" ");
        if (arguments.length < 1) throw new CommandException("No command");
        return switch (arguments[0]) {
            case "auth" -> new AuthCommand();
            case "edit" -> new EditCommand();
            case "list" -> new ViewCommand();
            case "create" -> new CreateCommand();
            case "dis" -> new DisconnectCommand();
            default -> throw new CommandException("No such command");
        };
    }
}
