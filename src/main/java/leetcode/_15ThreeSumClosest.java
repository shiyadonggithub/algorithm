package leetcode;

import java.util.Arrays;

public class _15ThreeSumClosest {
    public static void main(String[] args) {
        int[]nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums,1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (Math.abs(result - target) >
                        Math.abs(nums[i] + nums[left] + nums[right] - target)) {
                    result = nums[i] + nums[left] + nums[right];

                }
                if (nums[i] + nums[left] + nums[right] - target > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
