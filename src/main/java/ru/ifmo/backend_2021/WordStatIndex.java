package ru.ifmo.backend_2021;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


public class WordStatIndex {

    public static String getStats(String input) {
        String[] words = input.toLowerCase().split("[.,!?\\s:{}|;\"]+");

        LinkedHashMap<String, IntList> wordStats = new LinkedHashMap<>();

        for (int i = 0; i < words.length; i++) {

            if (!wordStats.containsKey(words[i])) {
                IntList frequencyList = new IntList();
                wordStats.put(words[i], frequencyList);
            }
            wordStats.get(words[i]).push(i + 1);
        }

        return getResult(wordStats);
    }

    private static String getResult(LinkedHashMap<String, IntList> wordStats) {

        if (wordStats.isEmpty()) return "";

        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, IntList> entry : wordStats.entrySet()) {

            String word = entry.getKey();
            int freq = entry.getValue().getSize();
            String indices = entry.getValue().convertToString();

            result.append(word).append(" ").append(freq).append(" ").append(indices).append("\n");
        }

        return result.substring(0, result.length() - 1);
    }
}