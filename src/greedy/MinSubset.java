package greedy;

import java.util.Arrays;

public class MinSubset {
    public static void main(String[] args) {
        System.out.println(new MinSubset().minSubset(new int[] {5, 3, 2, 8, 4, 1}, 6));
    }

    int minSubset(int[] a,int n) {
        int sum = 0;
        for (int num : a) {
            sum += num;
        }

        Arrays.sort(a);

        int c = 1, ans = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            int num = a[i];
            ans += num;
            if (ans > sum - ans) {
                return c;
            }
            c++;
        }
        return c;
    }
}

