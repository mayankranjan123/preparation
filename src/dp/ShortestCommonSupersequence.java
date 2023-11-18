package dp;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        System.out.println(new ShortestCommonSupersequence().shortestCommonSupersequence("abac", "cab"));
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        return lcs(str1, str2, str1.length(), str2.length());
    }

    String lcs(String p, String q, int m, int n) {
        int[][]dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (p.charAt(i - 1) == q.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = m, j = n;
        String res = "";

        while (i > 0 && j > 0) {
            if (p.charAt(i - 1) == q.charAt(j - 1)) {
                res = p.charAt(i - 1) + res;
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    res = q.charAt(j -1) + res;
                    j--;
                } else {
                    res = p.charAt(i -1) + res;
                    i--;
                }
            }
        }

        while (i > 0) {
            res = p.charAt(i -1) + res;
            i--;
        }

        while (j > 0) {
            res = q.charAt(j -1) + res;
            j--;
        }
        return res;
    }
}
