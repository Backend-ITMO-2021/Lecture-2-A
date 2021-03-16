package ru.ifmo.backend_2021;

import java.util.*;

public class WordStatIndex {
  public static String getStats(String input) {
    Map<String, IntList> wordsMap = new LinkedHashMap<>();
    String[] words = input.toLowerCase().split("[.,!?\\s:{}|;\"]+");
    int space = 0;
    StringBuilder result = new StringBuilder("");
    for (int i = 0; i < words.length; i++) {
      if (words[i] == " ") {
        space++;
        continue;
      }
      if (words[i].isEmpty() || words[i].isBlank()) {
        continue;
      }
      if (wordsMap.containsKey(words[i])) {
        wordsMap.get(words[i]).add(i + 1 - space);
      } else {
        IntList curIds = new IntList();
        curIds.add(i + 1 - space);
        wordsMap.put(words[i], curIds);

      }
    }
    for (String key : wordsMap.keySet()) {
      IntList curIds = wordsMap.get(key);
      result.append(key);
      result.append(" ");
      result.append(curIds.size());
      for (int id = 0; id < curIds.size(); id++) {
        result.append(" ");
        result.append(curIds.get(id));
      }
      result.append("\n");
    }
    return result.toString().trim();
  }
}
