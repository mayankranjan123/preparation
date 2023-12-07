package array;

import java.util.ArrayList;
import java.util.Arrays;

public class ClosestPair {
    public static void main(String[] args) {
        System.out.println(printClosest(new int[] {1, 4, 5, 7},
                new int[] {10, 20, 30, 40}, 4, 4, 32));
    }

    public static ArrayList<Integer> printClosest (int a[], int b[], int n, int m, int x) {
        // code here
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = m - 1;

        int min = Integer.MAX_VALUE;
        int ans1 = 0, ans2 = 0;

        while (i < n && j >= 0) {
            if (a[i] + b[j] > x) {
                if (Math.abs(x - (a[i] + b[j])) < min) {
                    min = Math.abs(x - (a[i] + b[j]));
                    ans1 = a[i];
                    ans2 = b[j];
                }
                j--;
            } else if (a[i] + b[j] < x) {
                if (Math.abs(x - (a[i] + b[j])) < min) {
                    min = Math.abs(x - (a[i] + b[j]));
                    ans1 = a[i];
                    ans2 = b[j];
                }
                i++;
            } else {
                ans1 = a[i];
                ans2 = b[j];
                ArrayList<Integer> res = new ArrayList<>();
                res.add(ans1);
                res.add(ans2);
                return res;
            }
        }

        i = n - 1; j = 0;

        while (i >= 0 && j < m) {
            if (a[i] + b[j] > x) {
                if (Math.abs(x - (a[i] + b[j])) < min) {
                    min = Math.abs(x - (a[i] + b[j]));
                    ans1 = a[i];
                    ans2 = b[j];
                }
                j++;
            } else if (a[i] + b[j] < x) {
                if (Math.abs(x - (a[i] + b[j])) < min) {
                    min = Math.abs(x - (a[i] + b[j]));
                    ans1 = a[i];
                    ans2 = b[j];
                }
                i--;
            } else {
                ans1 = a[i];
                ans2 = b[j];
                ArrayList<Integer> res = new ArrayList<>();
                res.add(ans1);
                res.add(ans2);
                return res;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(ans1);
        res.add(ans2);
        return res;
    }
}
