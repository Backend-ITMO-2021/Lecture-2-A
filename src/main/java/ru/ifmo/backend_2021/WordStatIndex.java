package ru.ifmo.backend_2021;

import java.util.LinkedHashMap;

public class WordStatIndex {
  public static void main(String[] args) {
    getStats("To be, or not to be, that is the question:");
  }

  public static String getStats(String input) {
    String[] wordsList = input.toLowerCase().replaceAll("[^а-яa-z'-]", " ").split("\\s+");
    int position = 1;
    LinkedHashMap<String, IntList> wordsStats = new LinkedHashMap<>();
    StringBuilder output = new StringBuilder();

    for (String word: wordsList) {
      wordsStats.putIfAbsent(word, new IntList());
      wordsStats.get(word).add(position++);
    }

    wordsStats.forEach((word, list) -> {
      output.append(word).append(" ").append(list.size()).append(list.toSB()).append("\n");
    });

    return output.toString().trim();
  }
}