package ru.dexsys;

import java.util.*;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;

public class ListService {
    private enum ListType {
        X {
            public BooleanSupplier getCondition(double number) {
                return () -> number % 3 == 0;
            }
        },
        S {
            public BooleanSupplier getCondition(double number) {
                return () -> number % 7 == 0;
            }
        },
        M {
            public BooleanSupplier getCondition(double number) {
                return () -> number % 21 == 0;
            }
        },
        OTHERS {
            public BooleanSupplier getCondition(double number) {
                return () -> !(number % 3 == 0) && !(number % 7 == 0) && !(number % 21 == 0);
            }
        };

        public abstract BooleanSupplier getCondition(double number);
    }

    private static final HashMap<ListType, List<Double>> lists = new HashMap<>();

    public static void init(double[] numbers) {
        var formattedNumbers = Arrays.stream(numbers).boxed().distinct().collect(Collectors.toList());
        Arrays.stream(ListType.values()).forEach(type -> {
            lists.putAll(formattedNumbers.stream()
                    .filter(dbl -> type.getCondition(dbl).getAsBoolean())
                    .sorted()
                    .collect(Collectors.groupingBy(g -> type)));
        });
    }

    public static String print() {
        return Arrays.stream(ListType.values())
                .filter(t -> !t.equals(ListType.OTHERS))
                .map(r -> lists.entrySet().stream()
                        .filter(s -> s.getKey().equals(r))
                        .findFirst()
                        .map(g -> String.format("%s list: %s", g.getKey().toString().toUpperCase(), g.getValue()))
                        .orElse(String.format("%s list is empty", r)))
                .collect(Collectors.joining("\n"));
    }

    public static String print(String type) throws Exception {
        try {
            var t = ListType.valueOf(type);
            return lists.entrySet().stream()
                    .filter(e -> e.getKey().equals(t))
                    .findFirst()
                    .map(s -> String.format("%s list: %s", s.getKey().toString().toUpperCase(), s.getValue()))
                    .orElse(String.format("%s list is empty", t.toString().toUpperCase()));

        } catch (IllegalArgumentException e) {
            throw new Exception("Type " + type + " doesn't exist.");
        }
    }

    public static String printIfAnyMoreExists() {
        return lists.entrySet().stream()
                .filter(s -> s.getKey().equals(ListType.OTHERS))
                .findFirst().map(r -> Boolean.TRUE)
                .orElse(Boolean.FALSE)
                .toString();
    }

    public static void clear(String type) throws Exception {
        try {
            var t = ListType.valueOf(type);
            lists.remove(t);
        } catch (IllegalArgumentException e) {
            throw new Exception("Type " + type + " doesn't exist.");
        }

    }

    public static String merge() {
        if (lists.entrySet().stream().filter(y -> !y.getKey().equals(ListType.OTHERS)).count() < 1) {
            return "Nothing to merge.";
        }

        var mergedLists = lists.entrySet().stream().filter(y -> !y.getKey().equals(ListType.OTHERS))
                .map(Map.Entry::getValue).flatMap(Collection::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        lists.clear();

        return mergedLists.toString();
    }
}
