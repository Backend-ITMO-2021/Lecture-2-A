package ru.ifmo.backend_2021;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;


public class WordStatIndex {
    ArrayList<IntList> myList = new ArrayList<>();

    public static String getStats(String input) {
        String[] words = input.toLowerCase().split("\\s+");

        LinkedHashMap<String, IntList> wordStats = new LinkedHashMap<>();

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^a-zA-Z0-9а-яА-Я\\-']", "");

            if (!wordStats.containsKey(words[i])) {
                IntList frequencyList = new IntList();
                wordStats.put(words[i], frequencyList);
            }
            wordStats.get(words[i]).push(i + 1);
        }

        return getResult(wordStats);
    }

    private static String getResult(LinkedHashMap<String, IntList> wordStats) {
//        System.out.println(wordStats);

        if (wordStats.isEmpty()) return "";

        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, IntList> entry : wordStats.entrySet()) {

            String word = entry.getKey();
            int freq = entry.getValue().getSize();
            String indexList = entry.getValue().convertToString();

            result.append(word).append(" ").append(freq).append(" ").append(indexList).append("\n");
        }

        return result.substring(0, result.length() - 1);
    }
}