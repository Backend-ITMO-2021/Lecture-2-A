package ru.ifmo.backend_2021;

import java.util.LinkedHashMap;
import java.util.Map;

public class WordStatIndex {

    public static String getStats(String input) {
        String[] words = input.toLowerCase().replaceAll("[^a-zа-я'-]", " ").split("\\s+");

        Map<String, IntList> wordsStats = new LinkedHashMap<>();

        for (int i = 0; i < words.length; ++i) {
            if (!wordsStats.containsKey(words[i])) {
                wordsStats.put(words[i], new IntList());
            }

            wordsStats.get(words[i]).add(i + 1);
        }

        StringBuilder result = new StringBuilder();
        for (String word : wordsStats.keySet()) {
            StringBuilder stats = new StringBuilder().append(wordsStats.get(word).size());

            for (Integer i : wordsStats.get(word)) {
                stats.append(" ").append(i);
            }

            result.append(word).append(" ").append(stats).append("\n");
        }

        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }
}
