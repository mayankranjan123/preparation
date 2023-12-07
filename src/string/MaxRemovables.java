package string;

import java.util.ArrayList;
import java.util.List;

public class MaxRemovables {
    public static void main(String[] args) {
        System.out.println(new MaxRemovables().maximumRemovals("abcbddddd", "abcd", new int[]{3,2,1,4,5,6}));
    }

    public int maximumRemovals(String s, String p, int[] removable) {
        int max = 0;
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < removable.length; i++) {
            index.add(Integer.valueOf(removable[i]));
            String temp = get(s, index);
            if (lcs(temp, p) != p.length() && !index.isEmpty()) {
                index.remove(Integer.valueOf(removable[i]));
                break;
            }
        }
        return index.size();
    }

    String get(String s, List<Integer> index) {
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (!index.contains(i)) {
                temp += s.charAt(i);
            }
        }
        return temp;
    }

    public int lcs(String a, String b) {
        int m = a.length(), n = b.length();
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];

        // return solve(a, b, 0, 0);
    }
}
