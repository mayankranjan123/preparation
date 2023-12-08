package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class FirstNegativeInWindow {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FirstNegativeInWindow().printFirstNegativeInteger(new long[] {12, -1, -7, 8, -15, 30, 16, 28}, 8, 3)));
    }

    public long[] printFirstNegativeInteger(long a[], int n, int k)
    {
        ArrayList<Long> temp = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();




        for (int i = 0; i < k; i++) {
            if (a[i] < 0) {
                q.add(i);
            }
        }

        if (!q.isEmpty()) {
            temp.add(a[q.getFirst()]);
        } else {
            temp.add(0L);
        }

        for (int i = k; i < n; i++) {
            if (!q.isEmpty() && i - q.getFirst() >= k) {
                q.removeFirst();
            }

            if (a[i] < 0) {
                q.add(i);
            }

            if (!q.isEmpty()) {
                temp.add(a[q.getFirst()]);
            } else {
                temp.add(0L);
            }
        }


        long[] res = new long[temp.size()];

        int i = 0;
        for (long num : temp) {
            res[i++] = num;
        }
        return res;

    }
}
