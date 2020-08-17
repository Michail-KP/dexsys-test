package ru.dexsys;

import ru.dexsys.command.Command;
import ru.dexsys.command.impl.Exit;
import ru.dexsys.command.impl.Start;

public class Main {
    public static void main(String[] args){
        ConsoleWorker.init();
        Command command = new Start();
        var mainDialog = ConsoleWorker.getDialogByParentCommand(command);
        do {
            try {
                command = ConsoleWorker.processDialog(mainDialog);
                var result = command.execute();
                ConsoleWorker.printResult(command.getClass().getSimpleName(), result);
            } catch (Exception e) {
                ConsoleWorker.printError(e.getMessage());
            }
        } while (!command.getClass().equals(Exit.class));
    }
}