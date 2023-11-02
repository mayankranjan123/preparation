package sort;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int a[] = {4, 2, 1, 3};
        cyclicSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void cyclicSort(int[] a) {
        int i = 0;
        while (i < a.length) {
            if (a[i] != a[a[i] - 1]) {
                int temp = a[a[i] - 1];
                a[a[i] - 1] = a[i];
                a[i] = temp;
            } else {
                i++;
            }
        }
    }


}
