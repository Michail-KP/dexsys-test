package ru.dexsys.dialog.impl;

import ru.dexsys.command.Command;
import ru.dexsys.command.impl.*;
import ru.dexsys.dialog.Dialog;

import java.util.ArrayList;

public class ChooseArrayFillingType extends Dialog {
    private static final String question = "How do you want to fill an array?\n" +
            ByLength.class.getSimpleName().toLowerCase() + " - to specify array length and fill it\n" +
            BySpace.class.getSimpleName().toLowerCase() + "  - to enter numbers separated by a space\n" +
            "Your choice: ";

    private static final DialogType type = DialogType.COMMAND;

    public ChooseArrayFillingType() {
        super();
        var relatedCommands = new ArrayList<Command>();
        relatedCommands.add(new ByLength());
        relatedCommands.add(new BySpace());
        relatedCommands.add(new Start());

        setRelatedCommands(relatedCommands);
        setParentCommand(new Init());
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
