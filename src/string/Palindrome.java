package string;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(new Palindrome().validPalindrome("abc"));
    }

    public boolean validPalindrome(String s) {
        StringBuffer sb = new StringBuffer(s);
        if (sb.reverse().toString().equals(s)) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            sb = new StringBuffer(s);
            String newStr = new String(sb.delete(i, i + 1));
            if (newStr.contentEquals(new StringBuffer(newStr).reverse())) {
                return true;
            }
        }
        return false;
    }
}
