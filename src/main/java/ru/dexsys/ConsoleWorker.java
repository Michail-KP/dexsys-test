package ru.dexsys;

import ru.dexsys.command.Command;
import ru.dexsys.command.impl.Exit;
import ru.dexsys.dialog.Dialog;
import ru.dexsys.dialog.impl.*;

import java.util.ArrayList;

public class ConsoleWorker {
    private static ArrayList<Dialog> dialogs;

    public static Dialog getDialogByParentCommand(Command parentCommand) {
        return dialogs.stream().filter(
                dialog -> dialog.getParentCommand().equals(parentCommand)
        ).findFirst().orElse(null);
    }

    public static void init() {
        dialogs = new ArrayList<>();
        dialogs.add(new Base());
        dialogs.add(new ChooseArrayFillingType());
        dialogs.add(new FillByLength());
        dialogs.add(new FillBySpace());
    }

    public static Command processDialog(Dialog dialog) throws Exception {
        try {
            Command cmd;
            System.out.print(dialog.getQuestion());
            if (dialog.getType().equals(DialogType.DATA)) {
                return dialog.getParentCommand();
            }

            var inp = dialog.getUserInput();
            cmd = dialog.getCommand(inp);

            if (cmd.getClass().equals(Exit.class)) {
                return cmd;
            }

            if (cmd.isNeedData()) {
                return processDialog(getDialogByParentCommand(cmd));
            }

            return cmd;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void printResult(String commandName, String result) {
        System.out.println("****************** Results of the '" + commandName + "' " +
                "command ******************\n" + result + "\n**************************************************\n");
    }

    public static void printError(String error) {
        System.out.println(error);
    }
}
