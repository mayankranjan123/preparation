package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int a[] = {9,5,4,3,7,2,1,0};
        int ans[] = mergeSort(a);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] mergeSort(int[] a) {
        if (a.length <= 1) {
            return a;
        }

        int mid = a.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(a, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(a, mid, a.length));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int merged[] = new int[first.length + second.length];

        int i = 0, j = 0, k = 0;

        while (i < first.length && j < second.length && k < merged.length) {
            if (first[i] < second[j]) {
                merged[k] = first[i];
                i++;
            } else {
                merged[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length) {
            merged[k++] = first[i++];
        }

        while (j < second.length) {
            merged[k++] = second[j++];
        }

        return merged;
    }
}
