package recursion;

import java.util.*;

public class Combination {
    public static void main(String[] args) {
        System.out.println(new Combination().combinationSum2(new int [] {2, 1, 4}, 7));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet<>();
        set = solve(candidates, target, 0, new ArrayList<>());

        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> li : set) {
            res.add(li);
        }

        return res;
    }

    Set<List<Integer>> solve(int[] nums, int target, int index, List<Integer> up) {
        if (index == nums.length && target == 0) {
            Set<List<Integer>> res = new HashSet<>();

            res.add(up);
            return res;
        }

        if (index == nums.length && target != 0) {
            return new HashSet<>();
        }

        Set<List<Integer>> res = new HashSet<>();

        for (int i = index; i < nums.length; i++) {
            if (nums[i] <= target) {
                up.add(nums[index]);
                res.addAll(solve(nums, target - nums[i], i + 1, up));
                up.remove(new Integer(nums[index]));
            }
        }
        return res;
    }
}
