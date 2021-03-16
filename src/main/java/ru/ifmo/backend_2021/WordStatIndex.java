package ru.ifmo.backend_2021;

import java.util.*;

public class WordStatIndex {
  public static String getStats(String input) {
    String[] words = input.toLowerCase().replaceAll("[^a-zA-Zа-яА-Я'\\s-]+", " ").split("\\s+");
    LinkedHashMap<String, IntList> dict = new LinkedHashMap<String, IntList>();
    StringBuilder output = new StringBuilder();

    for (int i =0; i < words.length; i++){
      if (dict.get(words[i]) == null) {
        IntList indexes = new IntList();
        indexes.add(i+1);
        dict.put(words[i], indexes);
      } else if (dict.get(words[i]) != null) {
        dict.get(words[i]).add(i+1);
      }
    }
    for(String key : dict.keySet()) {
      output.append(key).append(" ").append(dict.get(key).getSize()).append(" ").append(dict.get(key).print()).append("\n");
    }
    return output.toString().trim();
  }
}
