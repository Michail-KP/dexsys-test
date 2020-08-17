package ru.dexsys;

import java.util.*;

public class ListService {
    private static final ArrayList<Double> x = new ArrayList<>();
    private static final ArrayList<Double> s = new ArrayList<>();
    private static final ArrayList<Double> m = new ArrayList<>();
    private static final ArrayList<Double> others = new ArrayList<>();

    public static void init(double[] numbers) {
        for (Double number : numbers) {
            if ((number % 3) == 0) {
                x.add(number);
            }

            if ((number % 7) == 0) {
                s.add(number);
            }

            if ((number % 21) == 0) {
                m.add(number);
            }

            if (!x.contains(number) && !s.contains(number) && !m.contains(number)) {
                others.add(number);
            }
        }

        x.sort(Comparator.naturalOrder());
        s.sort(Comparator.naturalOrder());
        m.sort(Comparator.naturalOrder());
        others.sort(Comparator.naturalOrder());
    }

    public static String print() {
        return "All lists are below:\n" +
                "X list" + ((x.isEmpty()) ? " is empty" : ": " + x.toString()) + "\n" +
                "S list" + ((s.isEmpty()) ? " is empty" : ": " + s.toString()) + "\n" +
                "M list" + ((m.isEmpty()) ? " is empty" : ": " + m.toString());
    }

    public static String print(String type) throws Exception {
        return switch (type) {
            case "X" -> "X list" + ((x.isEmpty()) ? " is empty" : ": " + x.toString());
            case "S" -> "S list" + ((s.isEmpty()) ? " is empty" : ": " + s.toString());
            case "M" -> "M list" + ((m.isEmpty()) ? " is empty" : ": " + m.toString());
            default -> throw new Exception("Type " + type + " doesn't exist.");
        };

    }

    public static String printIfAnyMoreExists() {
        if (others.isEmpty()) {
            return "false";
        }

        return "true";
    }

    public static void clear(String type) throws Exception {
        switch (type) {
            case "X" -> x.clear();
            case "S" -> s.clear();
            case "M" -> m.clear();
            default -> throw new Exception("Type " + type + " doesn't exist.");
        }

    }

    public static String merge() {
        if (x.isEmpty() && s.isEmpty() && m.isEmpty()) {
            return "Nothing to merge.";
        }

        ArrayList<Double> mergedList = new ArrayList<>();
        mergedList.addAll(x);
        mergedList.addAll(s);
        mergedList.addAll(m);

        x.clear();
        s.clear();
        m.clear();
        others.clear();

        mergedList.sort(Comparator.naturalOrder());
        return mergedList.toString();
    }
}
