package array;

public class MaxOnes {
    public static void main(String[] args) {
        System.out.println(new MaxOnes().findMaxConsecutiveOnes(new int[] {1,0,1,1,0,1}));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ans += 1;
                max = Math.max(max, ans);
            } else {
                ans = 0;
            }
        }
        return ans;
    }
}
