package recursion;

import java.util.ArrayList;

public class TugOfWar {
    static int min = Integer.MAX_VALUE;
    static String ans = "";
    public static void main(String[] args) {
        tugOfWar(new int[] {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4}, new ArrayList<>(), new ArrayList<>(), 0, 0, 0);
        System.out.println(ans);
    }

    private static void tugOfWar(int[] num, ArrayList<Integer> ar1, ArrayList<Integer> ar2, int index, int sum1, int sum2) {
        if (index == num.length) {
            if (Math.abs(sum1 - sum2) < min) {
                min = Math.abs(sum1 - sum2);
                ans = ar1 + "" + ar2;
            }
            return;
        }

        if (ar1.size() < (num.length + 1) / 2) {
            ar1.add(num[index]);
            tugOfWar(num, ar1, ar2, index + 1, sum1 + num[index], sum2);
            ar1.remove(ar1.size() - 1);
        }

        if (ar2.size() < (num.length + 1) / 2) {
            ar2.add(num[index]);
            tugOfWar(num, ar1, ar2, index + 1, sum1, num[index] + sum2);
            ar2.remove(ar2.size() - 1);
        }
    }
}
