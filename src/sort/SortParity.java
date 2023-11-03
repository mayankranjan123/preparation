package sort;

import java.util.Arrays;

public class SortParity {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortParity().sortArrayByParityII(new int[] {2,0,3,4,1,3})));
    }

    public int[] sortArrayByParityII(int[] nums) {
        int even = 0;
        int lastIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0 && even < nums.length && i != lastIndex) {
                int temp = nums[i];
                nums[i] = nums[even];
                nums[even] = temp;
                lastIndex = even;
                even += 2;
            }
        }
        return nums;
    }
}
