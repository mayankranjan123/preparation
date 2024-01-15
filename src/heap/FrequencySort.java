package heap;

import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        int[] nums = new int[] {-1,1,-6,4,5,-6,1,4,1};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }

    private static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return 1;
                } else if (o1.getValue() < o2.getValue()) {
                    return -1;
                } else {
                    if (o1.getKey() > o2.getKey()) {
                        return 1;
                    } else if (o1.getKey() < o2.getKey()) {
                        return -1;
                    }
                    return 0;
                }
            }
        });

        List<Integer> temp = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            int times = entry.getValue();
            while (times > 0) {
                temp.add(entry.getKey());
                times -= 1;
            }
        }

        int[] res = new int[temp.size()];
        int i = 0;
        for (int num : temp) {
            res[i++] = num;
        }

        return res;
    }
}
