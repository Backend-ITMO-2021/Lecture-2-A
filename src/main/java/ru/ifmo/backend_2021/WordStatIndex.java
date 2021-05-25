package ru.ifmo.backend_2021;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class WordStatIndex {
  public static String getStats(String input) {
    LinkedHashMap<String, LinkedList<Integer>> counter = new LinkedHashMap<>();
    String[] words = input.toLowerCase().replaceAll("( )+", " ").strip().split("[^\\p{L}'\\-]+");
    for (int i = 0; i < words.length; i++) {
      counter.putIfAbsent(words[i], new LinkedList<>());
      counter.get(words[i]).add(i + 1);
    }

    StringBuilder stats = new StringBuilder("");
    counter.forEach((word, list) -> {
      stats.append(word).append(" ").append(list.size());
      list.forEach(i-> stats.append(" ").append(i));
      stats.append("\n");
    });
    stats.setLength(stats.length() - 1);
    return stats.toString();
  }
}
