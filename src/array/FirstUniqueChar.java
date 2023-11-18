package array;

public class FirstUniqueChar {
    public static void main(String[] args) {
        System.out.println(new FirstUniqueChar().firstUniqChar("leetcode"));
    }

    public int firstUniqChar(String s) {
        int[] nums = new int[128];

        for (char ch : s.toCharArray()) {
            int index = (int) ch;
            nums[index] += 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (nums[(int) s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
