package recursion;

import java.util.ArrayList;
import java.util.List;

public class PredictWinner {
    public static void main(String[] args) {
        System.out.println(new PredictWinner().predictTheWinner(new int[] {1,5,2}));
    }

    public boolean predictTheWinner(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return solve(list, 0, 0, true);
    }

    boolean solve(List<Integer> list, int c1, int c2, boolean p1) {
        if (list.isEmpty()) {
            if (c1 >= c2) {
                return true;
            }
            return false;
        }

        boolean ans1 = false;
        boolean ans2 = false;
        boolean ans3 = false;
        boolean ans4 = false;
        int index = 0;
        int num = list.get(index);
        list.remove(index);

        if (p1) {
            ans1 = ans1 | solve (list, c1 + num, c2, false);
        } else {
            ans2 = ans2 | solve (list, c1, c2 + num, true);
        }

        list.add(index, num);

        index = list.size() - 1;
        num = list.get(index);
        list.remove(index);

        if (p1) {
            ans3 = ans3 | solve (list, c1 + num, c2, false);
        } else {
            ans4 = ans4 | solve (list, c1, c2 + num, true);
        }

        list.add(index, num);


        return ans1 | ans2 | ans3 | ans4;
    }
}
