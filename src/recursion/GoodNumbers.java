package recursion;

public class GoodNumbers {
    public static void main(String[] args) {
        System.out.println(new GoodNumbers().countGoodNumbers(1));
    }

    private final int mod = (int) 1e9 + 7;
    public int countGoodNumbers(long n) {
        int oddPlaces = (int)(n/2) + 1;
        int evenPlaces = (int) (n/2);

        return pow(5, oddPlaces) * pow(4, evenPlaces);
    }

    int pow(int x, int y) {
        if (x == 0) {
            return 0;
        } else if (y == 0) {
            return 1;
        } else if (y % 2 == 0) {
            return pow(x, y/2) * pow(x, y/2);
        } else {
            return x * pow(x, y - 1);
        }
    }
}
