package ru.dexsys.command.impl;

import ru.dexsys.command.Command;

public class Init extends Command {
    public Init() {
        super(true);
    }

    @Override
    public String execute() {
        return "";
    }
}
