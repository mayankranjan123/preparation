package recursion;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }

    static Map<Integer, Integer> map = new HashMap<>();

    public static int climbStairs(int n) {
        if (n <= 1)
            return 1;
        if (map.containsKey(n))
            return map.get(n);
        int num = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, num);
        return num;
    }
}
