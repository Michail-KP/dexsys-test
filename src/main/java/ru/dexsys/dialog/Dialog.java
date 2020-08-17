package ru.dexsys.dialog;

import ru.dexsys.command.Command;
import ru.dexsys.dialog.impl.DialogType;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Dialog {
    protected ArrayList<Command> relatedCommands;
    private Command parentCommand;

    protected Scanner in;

    public Dialog() {
        in = new Scanner(System.in);
    }

    public void setRelatedCommands(ArrayList<Command> commands) {
        this.relatedCommands = commands;
    }

    public Command getParentCommand() {
        return parentCommand;
    }

    public void setParentCommand(Command parentCommand) {
        this.parentCommand = parentCommand;
    }

    public Command getCommand(String userString) throws Exception {
        Command command;
        var parts = userString.split(" ");
        command = relatedCommands.stream().filter(
                cmd -> cmd.getClass().getSimpleName().toLowerCase().equals(parts[0])
        ).findAny().orElse(null);

        if (command == null) {
            throw new Exception("Command " + parts[0] + " was not recognized.");
        }

        command.setArg(null);
        if (parts.length >= 2) {
            command.setArg(parts[1]);
        }

        return command;
    }

    public abstract String getUserInput() throws Exception;

    public abstract DialogType getType();

    public abstract String getQuestion();
}
