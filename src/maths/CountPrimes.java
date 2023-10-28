package maths;

public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {
        int[] primes = new int[n + 1];
        primes[0] = primes[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 2 * i; j < n; j = j + i) {
                if (primes[j] == 0) {
                    primes[j] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] == 0) {
                count += 1;
            }
        }

        return count;
    }
}