package ru.dexsys.command.impl;

import ru.dexsys.ListService;
import ru.dexsys.command.Command;

public class AnyMore extends Command {
    public AnyMore() {
        super(false);
    }

    @Override
    public String execute() {
        return ListService.printIfAnyMoreExists();
    }
}
