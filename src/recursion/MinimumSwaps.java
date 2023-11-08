package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumSwaps {
    public static void main(String[] args) {
        System.out.println(findMaximumNum("1234567", 4));
    }

    public static String findMaximumNum(String str, int k)
    {
        //code here.
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                List<Integer> list = map.get(ch);
                list.add(i);
                map.put(ch, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(ch, list);
            }
        }

        int i = 0;
        int temp = k;
        int indice = 0;


        char[] res = str.toCharArray();
        while (k > 0) {
            char num = '0';
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
                if (entry.getKey() - '0' >= num - '0') {
                    num = entry.getKey();
                    list = entry.getValue();
                    k = k - list.size();
                    map.remove(entry.getKey());
                }
            }


            for (Integer idx : list) {
                if (temp == 0) {
                    break;
                }

                char t1 = res[indice];
                res[indice] = res[idx];
                res[idx] = t1;

                indice += 1;
                temp -= 1;
            }

            if (temp == 0) {
                break;
            }
        }

        return new String(res);

    }
}
