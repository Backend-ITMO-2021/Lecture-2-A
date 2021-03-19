package ru.ifmo.backend_2021;

import java.util.*;

public class WordStatIndex {

  public static String getStats(String input) {
    String[] input_array = input.toLowerCase().trim().split(" [.,!?\\s:{}|;\"]+");
    Map<String, IntList> result = new HashMap<>();

    for (int i = 0; i < input_array.length; i++) {
      if (!result.containsKey(input_array[i])) {
        IntList new_info = new IntList(new int[]{1, i});
        result.put(input_array[i], new_info);
      } else {
        IntList updated_info = result.get(input_array[i]);
        updated_info.add(i);
        updated_info.set(updated_info.get(0) + 1, 0);
        result.replace(input_array[i], updated_info);
      }
    }
    String result_string = "";
    for (String s : input_array) {
      if (result.containsKey(s)) {
        result_string += s + " " + result.get(s).toString() + "\n";
        result.remove(s);
      }
    }
    return result_string.trim();
  }
}

