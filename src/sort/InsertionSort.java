package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int a[] = {5,4,3,7,2,1,0};
        // 4 5 3 2 1 0
        // 3 4 5 2 1 0
        // 2 3 4 5 1 0
        // 1 2 3 4 5 0
        // 0 1 2 3 4 5
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void insertionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                } else {
                    break;
                }
            }
        }

    }
}
