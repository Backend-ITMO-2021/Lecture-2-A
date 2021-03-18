package ru.ifmo.backend_2021;

import java.util.*;

public class WordStatIndex {
    private static final String PROHIBITED_SYMBOLS = "[^a-zA-Zа-яА-Я\\-'\n ]";

    public static String getStats(String input) {
        final LinkedHashMap<String, IntList> statistic = new LinkedHashMap<>();

        String[] words = input.replaceAll(PROHIBITED_SYMBOLS, " ").toLowerCase().split("\\s+");

        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            if (statistic.containsKey(word)) {

                statistic.get(word).add(i + 1);
            } else {

                IntList intList = new IntList();
                intList.add(i + 1);
                statistic.put(word, intList);
            }
        }
        StringBuilder output = new StringBuilder();

        statistic.forEach((key, positions) -> {

            output.append(String.format("%s %d", key, positions.size()));
            for (Integer pos : positions) {
                output.append(String.format(" %d", pos));
            }
            output.append('\n');
        });
        return output.toString().trim();
    }
}