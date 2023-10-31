package binary;

public class RotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new RotatedSortedArray().search(new int[] {4,5,6,7,0,1,2}, 0));
    }

    public int search(int[] nums, int target) {
        int pivot = getPivot(nums);
        int index = find(nums, 0, pivot - 1, target);
        if (index != -1) {
            return index;
        }
        return find(nums, pivot, nums.length - 1, target);
    }

    int getPivot(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1] && mid < nums.length - 1 &&
                    nums[mid] < nums[mid + 1]) {
                return mid;
            }  else if (nums[mid] > nums[end]){
                start = mid + 1;
            } else  {
                end = mid - 1;
            }
        }
        return start;
    }

    int find(int [] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
