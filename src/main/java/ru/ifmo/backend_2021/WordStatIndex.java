package ru.ifmo.backend_2021;


import java.util.LinkedHashMap;


public class WordStatIndex {

  public static void main(String[] args) {
    System.out.println(getStats("Шалтай-Болтай Сидел на стене. Шалтай-Болтай Свалился во сне."));

  }

  public static String getStats(String input) {


    String[] words = input.replaceAll("[^'a-zA-Zа-яА-Я0-9- \n]", " ").toLowerCase().split("\\s+");
    LinkedHashMap<String, String> map = new LinkedHashMap<>();
    String[] keyinorder;
    for (int i = 0; i< words.length; i++)
    {
      String word = words[i];


      String value = map.get(word);


      map.putIfAbsent(word,"0");
      String stat = map.get(word);

      Integer count = Integer.parseInt(stat.split(" ")[0]);
      String[] tail = stat.split(" ");
      count = count+1;
      tail[0]=count.toString();
      String output = String.join(" ", tail);
      output = output + " " + (i+1);
      map.put(word,output);



    }

    String restr = "";
    for (String key : map.keySet()) {
      restr+= key + " " + map.get(key) + "\n" ;
    }

    return restr.trim();
  }
}
