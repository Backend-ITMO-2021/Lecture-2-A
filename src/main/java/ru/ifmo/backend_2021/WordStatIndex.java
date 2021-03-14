package ru.ifmo.backend_2021;
import java.text.MessageFormat;
import java.util.Map;
import java.util.LinkedHashMap;

public class WordStatIndex {
  public static String getStats(String input) {
    String[] words = input.replaceAll("[^'a-zA-Zа-яА-Я0-9- \n]", " ").toLowerCase().split("\\s+");
    Map<String, IntList> wordMap = new LinkedHashMap<>();
    int counter = 0;
    for (String word : words) {
      wordMap.putIfAbsent(word, new IntList());
      wordMap.get(word).add(++counter);
    }
    StringBuilder sb = new StringBuilder();
    MessageFormat fmt = new MessageFormat("{0} {1} {2}\n");
    for (Map.Entry<String, IntList> word: wordMap.entrySet()){
      Object[] args = {word.getKey(), word.getValue().size(), convertArray(word.getValue().toString())};
      sb.append(fmt.format(args));
    }
    return sb.deleteCharAt(sb.lastIndexOf("\n")).toString();
  }
  private static String convertArray(String positions){
    return positions.substring(1, positions.length()-1).replace(",", "");
  }
}
