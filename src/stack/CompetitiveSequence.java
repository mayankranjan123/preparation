package stack;

import java.util.Stack;

public class CompetitiveSequence {
    public static void main(String[] args) {
        System.out.println(new CompetitiveSequence().mostCompetitive(new int[] {71,18,52,29,55,73,24,42,66,8,80,2}, 3));
    }

    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        if (nums.length == k) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            if (st.size() < k) {
                while (!st.isEmpty() && st.peek() > nums[i]) {
                    st.pop();
                }
                st.push(nums[i]);
            } else {
                while (!st.isEmpty() && st.peek() > nums[i]) {
                    st.pop();
                }

                if ((!st.isEmpty() && st.peek() <= nums[i] && st.size() < k) || (st.isEmpty())) {
                    st.push(nums[i]);
                }
            }
        }

        int[] res = new int[k];
        while (k > 0 && !st.isEmpty()) {
            res[k - 1] = st.pop();
            k--;
        }

        return res;
    }
}
