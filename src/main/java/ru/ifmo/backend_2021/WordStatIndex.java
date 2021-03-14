package ru.ifmo.backend_2021;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class WordStatIndex {

    public static void main(String[] args) {
        getStats("To be, or not to be, that is the question:");
    }


    public static String getStats(String input) {
        String[] text = input.split("[\\s,.:]+");

        Map<String, IntList> wordsCounter = new LinkedHashMap<>();

        for (int i = 0; i < text.length; i++) {
            String word = text[i].toLowerCase();
            wordsCounter.putIfAbsent(word, new IntList());
            wordsCounter.get(word).add(i + 1);
        }

        StringBuilder sb = new StringBuilder();

        wordsCounter.forEach((key, value) -> {
            String delimiter = " ";
            sb.append(key).append(delimiter).append(value.size()).append(delimiter);
            sb.append(value.stream().map(Object::toString)
                    .collect(Collectors.joining(delimiter)));
            sb.append("\n");
        });

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
