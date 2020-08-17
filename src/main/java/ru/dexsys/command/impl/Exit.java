package ru.dexsys.command.impl;

import ru.dexsys.command.Command;

public class Exit extends Command {
    public Exit() {
        super(false);
    }

    @Override
    public String execute() {
        return "Bye bye!";
    }
}
