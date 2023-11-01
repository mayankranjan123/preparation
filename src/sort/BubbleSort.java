package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int a[] = {5, 3, 1, 2, 4};
        // 3 1 2 4 5
        // 1 2 3 4 5

        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void bubbleSort(int[] a) {
        boolean isSwapped;
        for (int i = 0; i < a.length; i++) {
            isSwapped = false;
            for (int j = 1; j < a.length - i; j++) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }
}
