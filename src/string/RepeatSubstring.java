package string;

public class RepeatSubstring {
    public static void main(String[] args) {
        System.out.println(new RepeatSubstring().repeatedStringMatch("abc", "cabcabca"));
    }

    public int repeatedStringMatch(String a, String b) {
        if (a.length() > b.length() && !a.contains(b)) {
            return -1;
        } else if (a.contains(b)) {
            return 1;
        }

        int times = b.length() / a.length();

        String temp = a;
        for (int i = 0; i < 2 * times; i++) {
            if (a.contains(b)) {
                return i + 1;
            }
            a += temp;
        }

        return -1;
    }
}
