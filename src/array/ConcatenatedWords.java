package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenatedWords {
    public static void main(String[] args) {
        System.out.println(new ConcatenatedWords().findAllConcatenatedWordsInADict(new String[] {"cat","cats","catsdogcats",
                "dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            List<String> uniques = createWords(word);
            map.put(word, uniques);
        }

        Map<String, Integer> temp = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            for (String word : words) {
                for (String unique : entry.getValue()) {
                    if (word.equals(unique) && !entry.getKey().equals(word)) {
                        temp.put(entry.getKey(), temp.getOrDefault(entry.getKey(), 0) + 1);
                    }
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            if (entry.getValue() >= 2) {
                res.add(entry.getKey());
            }
        }

        return res;
    }

    List<String> createWords(String word) {
        int i = 0, j = 0;
        String temp = "";
        List<String> res = new ArrayList<>();
        while (i < word.length() && j < word.length()) {
            temp += word.charAt(i);
            res.add(temp);
            if (i == word.length() - 1 && j < word.length()) {
                j += 1;
                i = j;
                temp = "";
            } else {
                i += 1;
            }
        }

        return res;
    }
}
