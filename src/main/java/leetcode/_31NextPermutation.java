package leetcode;

import scala.math.Ordering;

public class _31NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 8, 3};
        _31NextPermutation nextPermutation = new _31NextPermutation();
//        nextPermutation.quickSort(nums, 0, nums.length - 1);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i] + "  ");
//        }
        System.out.println();
        nextPermutation.nextPermutation(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
    }

    public void nextPermutation(int[] nums) {
        int begin = -1, end = nums.length - 1;
        int max = Integer.MIN_VALUE;
        int beginNum = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i > 0; i--) {
            max = Math.max(max, nums[i]);
            if (max > nums[i - 1]) {
                begin = i - 1;
                beginNum = nums[i - 1];
                break;
            }
        }
        quickSort(nums, Math.max(begin, 0), end);


        if (begin >= 0 && begin < nums.length - 1) {
            int endIndex = 0, endNumber = 0;
            for (int i = begin; i < nums.length; i++) {
                if (nums[i] > beginNum) {
                    endIndex = i;
                    endNumber = nums[i];
                    break;
                }
            }
            for (int i = endIndex; i > begin; i--) {
                nums[i] = nums[i - 1];
            }
            nums[begin] = endNumber;
        }
    }

    private void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) return;
        int splitNum = nums[begin], splitIndex = begin;
        for (int i = begin + 1; i <= end; i++) {
            if (nums[i] <= splitNum) {
                int temp = nums[splitIndex + 1];
                nums[splitIndex + 1] = nums[i];
                nums[i] = temp;
                splitIndex++;
            }
        }
        nums[begin] = nums[splitIndex];
        nums[splitIndex] = splitNum;
        quickSort(nums, begin, splitIndex - 1);
        quickSort(nums, splitIndex + 1, end);
    }
}