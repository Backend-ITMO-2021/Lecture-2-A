package ru.ifmo.backend_2021;

import java.util.LinkedHashMap;
import java.util.Map;


public class WordStatIndex {
  public static String getStats(String input) {
    LinkedHashMap<String, IntList> wordsMap = new LinkedHashMap<>();
    String[] words = input.replaceAll("[^'a-zA-Zа-яА-Я0-9- \n]", " ").toLowerCase().split("\\s+");

    int index = 0;
    for (String word : words) {
      if (!wordsMap.containsKey(word)) {
        wordsMap.put(word, new IntList(new Integer[] { ++index }));
      } else {
        wordsMap.get(word).add(++index);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (Map.Entry<String, IntList> entry: wordsMap.entrySet()) {
      sb.append(String.format("%s %d", entry.getKey(), entry.getValue().size()));
      for (Integer position: entry.getValue()) {
        sb.append(String.format(" %d", position));
      }
      sb.append("\n");
    }

    return sb.toString().trim();
  }

  public static void main(String[] args) {
    String testString = "To be, or not to be, that is the question:";
    String result = WordStatIndex.getStats(testString);
    System.out.println(result);
  }
}
