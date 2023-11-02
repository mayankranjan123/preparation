package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int a[] = {9,5,4,3,7,2,1,0};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a, int low, int hi) {
        if (low >= hi) {
            return;
        }

        int s = low;
        int e = hi;

        int mid = s + (e - s) / 2;
        int pivot = a[mid];

        while (s <= e) {
            while (a[s] < pivot) {
                s++;
            }

            while (a[e] > pivot) {
                e--;
            }

            if (s <= e) {
                int temp = a[s];
                a[s] = a[e];
                a[e] = temp;
                s++;
                e--;
            }
        }

        quickSort(a, low, e);
        quickSort(a, s, hi);
    }
}
