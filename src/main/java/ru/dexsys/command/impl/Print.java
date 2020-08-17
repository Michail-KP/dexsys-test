package ru.dexsys.command.impl;

import ru.dexsys.ListService;
import ru.dexsys.command.Command;

public class Print extends Command {
    public Print() {
        super(false);
    }

    @Override
    public String execute() throws Exception {
        var arg = this.getArg();
        return (arg == null) ? ListService.print() : ListService.print(arg);
    }
}
