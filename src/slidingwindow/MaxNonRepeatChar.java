package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxNonRepeatChar {
    public static void main(String[] args) {
        System.out.println(new MaxNonRepeatChar().lengthOfLongestSubstring("aabaab!bb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int j = 0, max = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                j = map.get(ch) + 1;
                map.put(ch, i);
            } else {
                map.put(ch, i);
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
