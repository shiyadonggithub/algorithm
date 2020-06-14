package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _01TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        _01TwoSum twoSum = new _01TwoSum();
        int[] result = twoSum.twoSum(nums, target);
        // for (int i = 0; i < result.length; i++) {
        System.out.println("results:" + result[0] + "  " + result[1]);
        // }
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null)
            return null;
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                result[0] = hashMap.get(nums[i]);
                result[1] = i;
                break;
            }
            hashMap.put(target - nums[i], i);
        }
        return result;
    }
}
