package ru.ifmo.backend_2021;
import java.util.*;

public class WordStatIndex {
  public static String getStats(String input) {
      Map<String, IntList> wordsMap = new LinkedHashMap<>();
      Map<Integer, String> indexToWords = new LinkedHashMap<>();
      String[] subStr = input.replaceAll("[^a-zA-Zа-яА-Я\\-'\n ]", " ").toLowerCase().split("\\s+");
      String result = "";
      int countWord = 1;
      int countPos = 1;
      for (String i: subStr) {
          if (wordsMap.containsKey(i)) {
              wordsMap.get(i).add(countPos);
          }
          else {
              IntList intList = new IntList();
              intList.add(countPos);
              wordsMap.put(i, intList);
              indexToWords.put(countWord, i);
              countWord++;
          }
          countPos++;
        }

      for (int i=1; i< indexToWords.size(); i++) {
          result +=  String.format("%s %s%s\n", indexToWords.get(i), wordsMap.get(indexToWords.get(i)).getSize(), wordsMap.get(indexToWords.get(i)).getPos());
      }
      result +=  String.format("%s %s%s", indexToWords.get(indexToWords.size()), wordsMap.get(indexToWords.get(indexToWords.size())).getSize(), wordsMap.get(indexToWords.get(indexToWords.size())).getPos());


      return result;
  }
}
