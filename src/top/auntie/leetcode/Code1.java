package top.auntie.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Code1 {

    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (target-nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (sumMap.containsKey(result)) {
                return new int[]{sumMap.get(result), i};
            }
            sumMap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] result = new Code1().twoSum(new int[]{3,2,4}, 6);
        System.out.println(result[0] + ","+ result[1]);
    }

}
