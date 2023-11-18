package stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(calculateSpan(new int[] {68, 735, 101, 770, 525}, 5)));
    }

    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        // find previous greater (based on index)
        // https://www.youtube.com/watch?v=kCAMWbTCO1c&ab_channel=Pepcoding

        Stack<Integer> pg = new Stack<>();
        int [] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (pg.isEmpty() || price[pg.peek()] > price[i]) {
                pg.push(i);
                res[i] = 1;
            } else {
                while (!pg.isEmpty() && price[pg.peek()] < price[i]) {
                    pg.pop();
                }

                if (!pg.isEmpty()) {
                    res[i] = i - pg.peek();
                } else {
                    res[i] = i + 1;
                }
                pg.push(i);
            }
        }

        return res;

    }
}
