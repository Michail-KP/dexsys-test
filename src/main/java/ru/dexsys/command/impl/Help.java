package ru.dexsys.command.impl;

import ru.dexsys.command.Command;

public class Help extends Command {
    public Help() {
        super(false);
    }

    @Override
    public String execute() {
        return "Here is a full list of possible commands:\n" +
                Init.class.getSimpleName().toLowerCase() + "          - to initiate lists\n" +
                Print.class.getSimpleName().toLowerCase() + "         - to print all lists\n" +
                Print.class.getSimpleName().toLowerCase() + " type    - to print specific list (use 'X', 'S' or 'M' instead of 'type' word)\n" +
                AnyMore.class.getSimpleName().toLowerCase() + "       - to print values that weren't be included to any list\n" +
                Clear.class.getSimpleName().toLowerCase() + " type    - to clear specific list (use 'X', 'S' or 'M' instead of 'type' word)\n" +
                Merge.class.getSimpleName().toLowerCase() + "         - to combine all lists into one, print it on the screen and clear all lists\n" +
                Help.class.getSimpleName().toLowerCase() + "          - to show a full list of possible commands\n" +
                Exit.class.getSimpleName().toLowerCase() + "          - to finish program";
    }
}
