package ru.dexsys.command.impl;

import ru.dexsys.command.Command;

public class Start extends Command {
    public Start() {
        super(false);
    }

    @Override
    public String execute() {
        return "";
    }
}
