package recursion;

public class SkipCharacter {
    public static void main(String[] args) {
        System.out.println(skip("baccad", "", 'a'));
    }

    private static String skip(String s, String res, char ch) {
        if (s == null || s.isEmpty()) {
            return res;
        }
        if (s.charAt(0) != ch) {
            return skip(s.substring(1), res + s.charAt(0), ch);
        }
        return skip(s.substring(1), res, ch);
    }
}
