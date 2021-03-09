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

            if (!lastWord.isEmpty()) {
                words.add(lastWord.toString());
                lastWord.setLength(0);
            }
        }

        return words;
    }


    public static String getStatss(String input) {
        System.out.println(input.substring(0, 15));

        final Map<String, IntList> counter = new LinkedHashMap<>();
        int index = 1;

        for (String str : split(input)) {
            counter.computeIfAbsent(str, k -> new IntList()).insert(index);
            index++;
        }

        System.out.println(index);

        StringBuilder result = new StringBuilder();
        counter.forEach((k, v) -> result.append(k).append(' ').append(v).append('\n'));

        result.setLength(result.length() - 1);
        return result.toString();
//        return counter.entrySet().parallelStream()
//                .map(entry -> entry.getKey() + " " + entry.getValue())
//                .collect(Collectors.joining("\n"));
    }

    public static String getStats(String input) {
        return new f().testInput(input);
    }


    public static void main(String[] args) {
        var a = getStats("To be, or not to be, that\n is the question:");
        System.out.print(a);
    }
}