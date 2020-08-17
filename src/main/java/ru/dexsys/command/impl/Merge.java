package ru.dexsys.command.impl;

import ru.dexsys.ListService;
import ru.dexsys.command.Command;

public class Merge extends Command {
    public Merge() {
        super(false);
    }

    @Override
    public String execute() {
        return ListService.merge();
    }
}
