package binary;

public class Ceiling {
    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[] {'x', 'x', 'y', 'y'}, 'z'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start == letters.length ? letters[0] :  letters[start];
    }
}
