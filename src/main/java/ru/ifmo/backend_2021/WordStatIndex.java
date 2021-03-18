package ru.ifmo.backend_2021;

import java.util.LinkedHashMap;

public class WordStatIndex {
  public static String getStats(String input) {

    String[] words = input.replaceAll("[^'a-zA-Zа-яА-Я0-9- \n]", " ").toLowerCase().split("\\s+");
    LinkedHashMap<String, IntList> stats = new LinkedHashMap<>();
    StringBuilder output = new StringBuilder();

    for (int i = 0; i < words.length; i++) {
      String word = words[i].toLowerCase();
      stats.putIfAbsent(word, new IntList());
      stats.get(word).add(i + 1);
    }

    stats.forEach((k, v) -> {
      output.append(String.format("%s %d%s", k, v.size(), v.toString()));
      if (words[words.length - 1] != k) {
        output.append("\n");
      }
    });

    return output.toString().trim();
  }
}