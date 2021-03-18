package ru.ifmo.backend_2021;

import java.util.LinkedHashMap;

public class WordStatIndex {
    public static String getStats(String input) {

        String[] words = input.replaceAll("[^a-zA-Zа-яА-Я\\-'\n]", " ").toLowerCase().split("\\s+");
        LinkedHashMap<String, IntList> dictionary = new LinkedHashMap<>();
        StringBuilder output = new StringBuilder();
        int counter = 0;
        for (String word : words) {
            dictionary.putIfAbsent(word, new IntList());
            dictionary.get(word).add(++counter);
        }
        for (String word : dictionary.keySet())
            output.append(word).append(" ").append(dictionary.get(word).size()).append(dictionary.get(word)).append("\n");
        System.out.println(output.deleteCharAt(output.length() - 1).toString());
        return output.toString();
    }
}
