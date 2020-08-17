package ru.dexsys.command.impl;

import ru.dexsys.ListService;
import ru.dexsys.command.Command;

import java.util.Arrays;
import java.util.Scanner;

public class ByLength extends Command {
    public ByLength() {
        super(true);
    }

    @Override
    public String execute() {
        var in = new Scanner(System.in);
        System.out.print("Array length: ");
        while (!in.hasNextInt()) {
            System.out.println("You should type int value here. Please, try again.");
            in.next();
        }
        var arrayLength = in.nextInt();
        var doubles = new double[arrayLength];
        for (var i = 0; i < arrayLength; i++) {
            System.out.print("Value " + i + ": ");
            while (!in.hasNextDouble()) {
                System.out.println("You should type only number values. Please, try again.");
                in.next();
            }
            doubles[i] = in.nextDouble();
        }
        ListService.init(doubles);
        return Arrays.toString(doubles);
    }
}
