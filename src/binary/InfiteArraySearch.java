package binary;

public class InfiteArraySearch {
    public static void main(String[] args) {

        int arr[] = {3, 5, 7, 9, 10, 90, 100, 130,
                140, 160, 170};
        int ans = findPos(arr, 221);
        System.out.println(ans);
    }

    private static int findPos(int[] nums, int target) {
        int start = 0, end = 1;
        while (nums[end] < target) {
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }

        return binarySearch(nums, start, end, target);
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
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
