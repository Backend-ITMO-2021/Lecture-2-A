package ru.ifmo.backend_2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordStatIndex {
    public static String getStats(String input) {
        String[] splitted = input.toLowerCase().split("[^-'\\p{L}]");
        Map<String, IntList> wordCount = new HashMap();
        List<String> wordOrder = new ArrayList(); // Чтобы вывести в том же порядке.
        int i = 1;
        for (String word : splitted) {
            if (word.length() == 0)
                continue; //Если строка со словами пустая, то пропускаем цикл.
            if (wordCount.containsKey(word)) {
                IntList list = wordCount.get(word);
                Node head = list.getHead(); //Берём количество раз, сколько встретилось.
                head.setData(head.data + 1); //Показаывем, что встретилось на раз больше.
                list.setHead(head); //Заменим в нашем экземпляре IntList первый элемент на новое значение.
                list.add(new Node(i));
                i += 1;
                wordCount.put(word, list);
            } else {
                IntList list = new IntList();
                list.add(new Node(1));
                list.add(new Node(i));
                i += 1;
                wordCount.put(word, list);
                wordOrder.add(word);
            }
        }
        String result = "";

        int j = 0;
        for (String word : wordOrder) {
        	j += 1;
        	result += word;
            for (Integer n : wordCount.get(word)) {
                result += " " + n;
            }

            if(j < wordOrder.size()) {
            	result += "\n";
        	}
        }
        return result;
    }
}
