package greedy;

import java.util.ArrayList;
import java.util.List;

public class MinCoin {
    public static void main(String[] args) {
        System.out.println(minPartition(43));
    }

    static List<Integer> minPartition(int n)
    {
        // code here
        int coins[] = new int[] {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

        int rem = n, ans = 0;

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= rem) {
                if (rem % coins[i] == 0) {
                    ans = rem / coins[i];
                    add(res, ans, coins[i]);
                    rem = 0;
                } else {
                    ans += rem / coins[i];
                    add(res, rem/coins[i], coins[i]);
                    rem = rem % coins[i];
                }
            }
        }

        return res;

    }

    static void add(List<Integer> res, int times, int coin) {
        for (int i = 0; i < times; i++) {
            res.add(coin);
        }
    }
}
