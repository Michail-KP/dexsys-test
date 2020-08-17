package ru.dexsys.command.impl;

import ru.dexsys.ListService;
import ru.dexsys.command.Command;

import java.util.Arrays;
import java.util.Scanner;

public class BySpace extends Command {
    public BySpace() {
        super(true);
    }

    @Override
    public String execute() {
        var in = new Scanner(System.in);
        var isOk = true;
        double[] doubles = new double[0];
        do {
            try {
                System.out.print("Type values: ");
                var l = in.nextLine();
                var strValues = l.split(" ");
                doubles = new double[strValues.length];
                for(var i = 0; i < strValues.length; i++) {
                    doubles[i] = Double.parseDouble(strValues[i]);
                }
            } catch (NumberFormatException e) {
                System.out.println("This line has not only double values. Please, try again.");
                isOk = false;
            }
        } while (!isOk);

        ListService.init(doubles);
        return Arrays.toString(doubles);
    }
}
