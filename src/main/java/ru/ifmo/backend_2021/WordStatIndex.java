package ru.ifmo.backend_2021;

import java.util.LinkedHashMap;
import java.util.Locale;

public class WordStatIndex {
  public static void main(String[] args) {
    getStats("To be, or not to be, that is the question:");
  }
  public static String getStats(String input) {
    LinkedHashMap<String, IntList> places = new LinkedHashMap<>();
    StringBuilder output = new StringBuilder();
    String[] words = input.toLowerCase(Locale.ROOT).replaceAll("[^a-zа-я'-]", " ").split("\\s+");
    for(int i = 0; i < words.length; i++){
      if (!places.containsKey(words[i])) {
        places.put(words[i], new IntList());
      }
      places.get(words[i]).append(i + 1);
    }
    for (String word: places.keySet()){
      output.append(word).append(" ").append(places.get(word).size()).append(places.get(word)).append("\n");
    }
    System.out.println(output.deleteCharAt(output.length()-1).toString());
    return output.toString();
  }
}
