package string;

public class ShiftLetter {
    public static void main(String[] args) {
        System.out.println(new ShiftLetter().shiftingLetters("abc", new int[] {3, 5, 9}));
    }

    public String shiftingLetters(String s, int[] shifts) {
        String temp = s;
        for (int i = 0; i < shifts.length; i++) {
            temp = shift(temp, i, shifts[i]);
        }
        return temp;
    }

    String shift(String s, int index, int num) {
        String temp = "";
        for (int i = 0; i <= index; i++) {
            int rem = num % 26;
            temp = temp +  ((char) ((int) s.charAt(i) + rem) % 97);
        }
        return temp;
    }
}
