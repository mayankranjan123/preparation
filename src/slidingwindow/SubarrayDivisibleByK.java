package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubarrayDivisibleByK {

    public static void main(String[] args) {
        System.out.println(new SubarrayDivisibleByK().solve(new int[] {4,5,0,-2,-3,1}, 5));
    }

    public int solve(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, sum = 0, rem = 0;
        map.put(sum, 1);

        for (int num : nums) {
            sum += num;
            rem = sum % k;
            if (rem < 0) {
                rem = rem + k;
            }

            if (map.containsKey(rem)) {
                ans += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return ans;

    }
}
