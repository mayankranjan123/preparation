package slidingwindow;

import java.util.*;

public class SlidingMaximum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SlidingMaximum().slidingWindow(new int[] {1, 3, 1, 2, 0, 5}, 3)));
    }

    int[] slidingWindow(int[] a, int k) {
        Deque<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && a[q.getLast()] < a[i]) {
                q.removeLast();
            }
            q.addLast(i);
        }

        for (int i = k; i < a.length; i++) {
            if (!q.isEmpty()) {
                list.add(a[q.getFirst()]);
            }

            while (!q.isEmpty() && a[q.getLast()] < a[i]) {
                q.removeLast();
            }

            if (!q.isEmpty() && i - q.getFirst() >= k) {
                q.removeFirst();
            }
            q.addLast(i);
        }

        if (!q.isEmpty())
            list.add(a[q.getFirst()]);

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;

    }
}
