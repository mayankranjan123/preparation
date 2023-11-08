package recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(3, 2));
    }

    public String getPermutation(int n, int k) {
        int[] fact = new int[n + 1];
        fact[0] = fact[1] = 1;
        for (int i = 2; i <= n; i++) {
            fact[i] = i * fact[i - 1];
        }

        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        String ans = "";
        while (true) {
            int f = fact[n - 1];
            int index = (k % f);
            ans = ans + numbers.get(index);

            numbers.remove(index);
            if (numbers.size() == 1) {
                ans = ans + numbers.get(0);
                break;
            }
            n -= 1;

        }

        return ans;
    }
}
