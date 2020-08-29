package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class _18FourSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
        int target = -9;
        List<List<Integer>> res = fourSum(nums, target);
        Iterator<List<Integer>> listIterator = res.iterator();
        while (listIterator.hasNext()) {
            List<Integer> list = listIterator.next();
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next());
                System.out.print("    ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 3; first++) {
            //if (nums[first] > target) break;
            for (int second = first + 1; second < nums.length - 2; second++) {
                int left = second + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[first] + nums[second] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> ele = Arrays.asList(nums[first], nums[second], nums[left], nums[right]);
                        result.add(ele);
                        while (left < right  && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                    if (sum > target) {
                        right--;
                    }
                    if (sum < target) {
                        left++;
                    }
                }
                while (second < nums.length - 2 && nums[second] == nums[second + 1]) second++;
            }
            while (first < nums.length - 3 && nums[first] == nums[first + 1]) first++;
        }
        return result;
    }
}
