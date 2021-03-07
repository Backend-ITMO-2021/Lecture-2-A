package ru.ifmo.backend_2021;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordStatIndex {

    public static void main(String[] args) {
        getStats("To be, or not to be, that is the question:");
    }

    public static String getStats(String input) {
        String[] punctuationFreeInput = input.split("[\\s,.:]+");

        Map<String, IntList> wordsCounter = new LinkedHashMap<>();

        for (int i = 0; i < punctuationFreeInput.length; i++) {
            String word = punctuationFreeInput[i].toLowerCase();
            wordsCounter.putIfAbsent(word, new IntList());
            wordsCounter.get(word).add(i + 1);
        }

        /*Map<String, List<Integer>> wordsCounter2 = IntStream
                .range(0, punctuationFreeInput.length)
                .boxed()
                .parallel()
                .map(index -> {
                    List<Integer> intList = new IntList();
                    intList.add(index + 1);
                    Map<String, List<Integer>> wordCounter = new LinkedHashMap<>();
                    wordCounter.put(punctuationFreeInput[index].toLowerCase(), intList);
                    return wordCounter;
                })
                .reduce((map1, map2) -> {
                    map2.forEach((key, value) -> map1.merge(key, value, (v1, v2) -> {
                        v1.addAll(v2);
                        return v1;
                    }));
                    return map1;
                }).get();

        System.out.println(wordsCounter2);*/

        StringBuilder sb = new StringBuilder();

        wordsCounter.forEach((key, value) -> {
            String delimiter = " ";
            sb.append(key).append(delimiter).append(value.size()).append(delimiter);
            sb.append(value.stream().map(Object::toString)
                    .collect(Collectors.joining(delimiter)));
            sb.append("\n");
        });

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
