package sort;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] {"", ""}));
    }

    public static List<List<String>> groupAnagrams(String[] s) {
        if (s == null || s.length == 0) {
            return new ArrayList<>();
        } else if  (s.length == 1 && s[0] == "") {
            List<List<String>> res = new ArrayList<>();
            List<String> inner = new ArrayList<>();
            inner.add("");
            res.add(inner);
            return res;
        } else {
            List<List<String>> res = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            for (String st : s) {
                char[] sorted = st.toCharArray();
                Arrays.sort(sorted);
                String sort = new String(sorted);
                if (map.get(sort) == null) {
                    List<String> inner = new ArrayList<>();
                    inner.add(st);
                    map.put(sort, inner);
                } else {
                    List<String> exist = map.get(sort);
                    exist.add(st);
                    map.put(sort, exist);
                }
            }

            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                res.add(entry.getValue());
            }
            return res;
        }
    }
}
