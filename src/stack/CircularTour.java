package stack;

public class CircularTour {
    public static void main(String[] args) {

    }

    int tour(int petrol[], int distance[])
    {
        // Your code here
        int start = 0, rem = 0, ans = 0;

        while (true) {
            rem = rem + petrol[start];

            if (rem >= distance[start]) {
                rem = rem - distance[start];
                start = (start + 1) % petrol.length;
            } else {
                rem = 0;
                start = (start + 1) % petrol.length;
                ans = start;
            }

            if (ans == start) {
                break;
            }
        }

        return ans;
    }
}
