package ru.dexsys.dialog.impl;

import ru.dexsys.command.impl.BySpace;
import ru.dexsys.dialog.Dialog;

public class FillBySpace extends Dialog {
    private static final String question = "Print values via space. Type 'enter' to finish typing\n";
    private static final DialogType type = DialogType.DATA;

    public FillBySpace() {
        setParentCommand(new BySpace());
    }

    public DialogType getType() {
        return type;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getUserInput() {
        return "";
    }
}
