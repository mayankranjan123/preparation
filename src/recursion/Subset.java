package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        System.out.println(subset("abc", "", new ArrayList<>()));
        System.out.println(subset("abc", ""));
        System.out.println(subset("abc"));
    }

    private static List<String> subset(String up, String p, List<String> res) {
        if (up.isEmpty()) {
            if (!res.contains(p)) {
                res.add(p);
            }
            return res;
        }

        subset(up.substring(1), p + up.charAt(0), res);
        subset(up.substring(1), p, res);

        return res;
    }

    private static List<String> subset(String up, String p) {
        if (up.isEmpty()) {
            List<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }

        List<String> left = subset(up.substring(1), p + up.charAt(0));
        List<String> right = subset(up.substring(1), p);

        left.addAll(right);

        return left;
    }

    static List<String> subset(String up) {
        List<String> outer = new ArrayList<>();
        outer.add("");

        for (char ch : up.toCharArray()) {
            int size = outer.size();

            for (int i = 0; i < size; i++) {
                String internal = outer.get(i);
                outer.add(internal + ch);
            }
        }
        return outer;
    }
}
