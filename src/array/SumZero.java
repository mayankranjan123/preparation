package array;

public class SumZero {
    public static void main(String[] args) {
        System.out.println(sumZero(5));
    }

    public static int[] sumZero(int n) {
        int ans[] = new int[n];
        int j = 0;
        for (int i = 1; i <= n/2; i++) {
            ans[j++] = i;
            ans[j++] = -i;
        }
        if (n % 2 != 0) {
            ans[j] = 0;
        }
        return ans;
    }
}
