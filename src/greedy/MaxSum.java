package greedy;

import java.util.Arrays;

public class MaxSum {
    public static void main(String[] args) {
        System.out.println(new MaxSum().largestSumAfterKNegations(new int[] {-8,3,-5,-3,-5,-2}, 6));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] < 0 && nums[i + 1] < 0) {
                if (k  > 0) {
                    sum += (-nums[i]);
                    k--;
                } else {
                    sum += nums[i];
                }
            } else if (nums[i] < 0) {
                if (k > 0) {
                    if (i == nums.length - 1) {
                        if (k % 2 == 0) {
                            sum += nums[i];
                        } else {
                            sum += (-nums[i]);
                        }
                        k = 0;
                    } else {
                        if (i + 1 < nums.length && nums[i + 1] >= 0) {
                            if (k % 2 == 0) {
                                sum += (nums[i]);
                                k = 0;
                            } else {
                                sum += -(nums[i]);
                                k = 0;
                            }
                        } else {
                            sum += (-nums[i]);
                            k--;
                        }
                    }
                } else {
                    sum += nums[i];
                }
            } else if (nums[i] >= 0) {
                if (k % 2 == 0) {
                    sum += nums[i];
                    k = 0;
                } else {
                    sum += (-nums[i]);
                    k--;
                }
            }
        }
        return sum;
    }
}
