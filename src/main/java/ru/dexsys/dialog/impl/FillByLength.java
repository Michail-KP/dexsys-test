package ru.dexsys.dialog.impl;

import ru.dexsys.command.impl.ByLength;
import ru.dexsys.dialog.Dialog;

public class FillByLength extends Dialog {
    private static final String question = "Specify the length of the array and then type values.\n";
    private static final DialogType type = DialogType.DATA;

    public FillByLength() {
        setParentCommand(new ByLength());
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
