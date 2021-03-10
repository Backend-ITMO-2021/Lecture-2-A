package ru.ifmo.backend_2021;

import java.util.*;

public class WordStatIndex {
    public static String getStats(String input) {
        Map<String, IntList> counter = new LinkedHashMap<>();
        String[] words = input.toLowerCase().split("[.,!?\\s:{}|;\"]+");
        for (int i = 0; i < words.length; i++) {
            if(words[i].isEmpty() || words[i].isBlank())
                continue;
            counter.putIfAbsent(words[i].strip(), new IntList());
            counter.get(words[i].strip()).add(i + 1);
        }
        StringBuilder stat = new StringBuilder("");
        counter.forEach((word, list) -> {
            stat.append(word).append(" ");
            stat.append(list.size());
            list.forEach(i-> stat.append(" ").append(i));
            stat.append("\n");
        });
        stat.delete(stat.length()-1,stat.length());
        return stat.toString();
    }
}
