package ru.ifmo.backend_2021;

import java.util.*;
import java.util.stream.Collectors;

public class WordStatIndex {

    public static List<String> split(String input) {
        final List<String> words = new ArrayList<>();
        final StringBuilder lastWord = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isLetter(c) || c == '-' || c == '\'') {
                lastWord.append(Character.toLowerCase(c));
                continue;
            }

            if (lastWord.length() > 0) {
                words.add(lastWord.toString());
                lastWord.setLength(0);
            }
        }

        if (lastWord.length() > 0) {
            words.add(lastWord.toString());
        }

        return words;
    }


    public static String getStats(String input) {

        final Map<String, IntList> counter = new LinkedHashMap<>();
        int index = 1;

        for (String str : split(input)) {
            counter.computeIfAbsent(str, k -> new IntList()).insert(index);
            index++;
        }
        return counter.entrySet().parallelStream()
                .map(entry -> entry.getKey() + " " + entry.getValue())
                .collect(Collectors.joining("\n"));
    }
}