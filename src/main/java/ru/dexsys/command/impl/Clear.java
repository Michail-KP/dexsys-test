package ru.dexsys.command.impl;

import ru.dexsys.ListService;
import ru.dexsys.command.Command;

public class Clear extends Command {
    public Clear() {
        super(false);
    }

    @Override
    public String execute() throws Exception {
        ListService.clear(getArg());
        return "done!";
    }
}
