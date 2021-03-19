package ru.ifmo.backend_2021;

import java.util.*;

public class WordStatIndex {
  private static final String RIGHT_CHARS = "[^a-zA-Zа-яА-Я'\n\\- ]";

  public static String getStats(String input) {
    Map<String, IntList> wordsCounter = new LinkedHashMap<>();
    String[] words = input.replaceAll(RIGHT_CHARS, " ").toLowerCase().split("\\s+");

    for (int i = 1; i <= words.length; i++) {
      String word = words[i - 1].strip();
      if (word.isBlank() || word.isEmpty()) continue;
      if (wordsCounter.get(word) == null) wordsCounter.put(word, new IntList());
      wordsCounter.get(word).add(i);
    }

    StringBuilder result = new StringBuilder();

    wordsCounter.forEach((word, stat) -> {
      result.append(word).append(" ").append(stat.size());
      stat.forEach(position -> result.append(" ").append(position));
      result.append("\n");
    });

    result.setLength(result.length() - 1);
    return result.toString();
  }
}
