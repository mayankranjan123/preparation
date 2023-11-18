package array;

public class StringInterleave {

    public static void main(String[] args) {
        System.out.println(new StringInterleave().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int i = 0, j = 0, k = 0;

        while (k < s3.length() && i < s1.length() && j < s2.length()) {
            if (s3.charAt(k) == s1.charAt(i)) {
                i++;
                k++;
            } else if (s3.charAt(k) == s2.charAt(j)) {
                j++;
                k++;
            } else {
                return false;
            }
        }

        while (i < s1.length() && k < s3.length()) {
            if (s3.charAt(k) == s1.charAt(i)) {
                i++;
                k++;
            }
            return false;
        }

        while (j < s2.length() && k < s3.length()) {
            if (s3.charAt(k) == s2.charAt(j)) {
                j++;
                k++;
            }
            return false;
        }

        return i == s1.length() && j == s2.length() && k == s3.length();
    }
}
