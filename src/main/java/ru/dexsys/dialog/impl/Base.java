package ru.dexsys.dialog.impl;

import ru.dexsys.command.Command;
import ru.dexsys.command.impl.*;
import ru.dexsys.dialog.Dialog;

import java.util.ArrayList;

public class Base extends Dialog {
    private static final String question = "Please, type 'help' to see all possible commands.\nYour choice: ";
    private static final DialogType type = DialogType.COMMAND;

    public Base() {
        super();
        var relatedCommands = new ArrayList<Command>();
        relatedCommands.add(new AnyMore());
        relatedCommands.add(new Clear());
        relatedCommands.add(new Exit());
        relatedCommands.add(new Merge());
        relatedCommands.add(new Print());
        relatedCommands.add(new Help());
        relatedCommands.add(new Init());

        setRelatedCommands(relatedCommands);
        setParentCommand(new Start());
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public DialogType getType() {
        return type;
    }

    @Override
    public String getUserInput() {
        return in.nextLine();
    }
}
