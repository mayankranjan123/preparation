package sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int a[] = {5,4,3,2,1,0};
        // 3 1 2 4 5
        // 1 2 3 4 5
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int index = findMaxElementIndex(a, 0, a.length - i - 1);
            int temp = a[index];
            a[index] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
    }

    private static int findMaxElementIndex(int[] a, int start, int end) {
        int max = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = start; i <= end; i++) {
            if (a[i] > max) {
                max = a[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
