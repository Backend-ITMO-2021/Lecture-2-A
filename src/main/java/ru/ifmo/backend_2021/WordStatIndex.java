package ru.ifmo.backend_2021;

import java.util.LinkedHashMap;

public class WordStatIndex {

  public static String getStats(String input) {
    String[] text = input.replaceAll("[^'a-zA-Zа-яА-Я0-9- \n]", " ").toLowerCase().split("\\s+");

    LinkedHashMap<String, IntList> stats = new LinkedHashMap<>();

    for (int i = 0; i < text.length; i++) {
      String word = text[i].toLowerCase();
      stats.putIfAbsent(word, new IntList());
      stats.get(word).add(i + 1);
    }

    StringBuilder output = new StringBuilder();

    stats.forEach((key, value) -> {
      output.append(key).append(" ").append(value.size());
      for (int val : value) {
        output.append(" ").append(val);
      }
      output.append('\n');
    });

    output.deleteCharAt(output.length() - 1);
    /*System.out.println(output.toString());*/
    return output.toString();
  }
}
