package ru.ifmo.backend_2021;

import java.util.Arrays;

public class WordStatIndex {
  public static String getStats(String input) {
    String str = input.toLowerCase();
    str = str.replaceAll("[,.:;()?!]", "");
    String[] subStr;
    String delimeter = " ";
    subStr = str.split(delimeter);
    String[] uq = Arrays.stream(subStr).distinct().toArray(String[]::new);
    String result = "";
    for (String i: uq) {
      int count = 0;
      String pos = "";
      for (int j=0; j<subStr.length;j++){
        if (i.equals(subStr[j])){
          count ++;
          pos += String.format("%s ", j+1);
        }
      }
      result +=  String.format("%s %s %s \n", i, count, pos);

    }

    return result;
  }
}
