package string;

public class MaxSubstring {
    public static void main(String[] args) {
        System.out.println(new MaxSubstring().maxRepeating("ababc", "ab"));
    }

    public int maxRepeating(String sequence, String word) {
        int i = 0, ans = 0;

        while (i < sequence.length()) {
            if (sequence.substring(i).startsWith(word)) {
                ans += 1;
                i += word.length();
            }
            i++;
        }
        return ans;
    }
}
