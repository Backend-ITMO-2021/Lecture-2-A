package ru.ifmo.backend_2021;

import java.util.LinkedHashMap;

public class WordStatIndex {
  public static String getStats(String input) {
    String[] listForWords = input.toLowerCase().replaceAll("[^a-zA-Zа-яА-Я'\\s-]+", " ").split("\\s+");
    LinkedHashMap<String, IntList> wordState = new LinkedHashMap<String, IntList>();
    for (int i =0; i < listForWords.length; i++){
      if (wordState.get(listForWords[i]) == null) {
        IntList indexes = new IntList();
        indexes.add(i+1);
        wordState.put(listForWords[i], indexes);
      } else if (wordState.get(listForWords[i]) != null) {
        wordState.get(listForWords[i]).add(i+1);
      }
    }
    StringBuilder output = new StringBuilder();
    for(String word : wordState.keySet()) {
      output.append(word).append(" ").append(wordState.get(word).getSize()).append(" ").append(wordState.get(word).print()).append("\n");
    }
    return output.toString().trim();
  }
}
