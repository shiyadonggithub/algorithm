package leetcode;

public class _26RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        _26RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new _26RemoveDuplicatesFromSortedArray();
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++)
            System.out.println(nums[i]);
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return length;
        int result = 1;
        int curNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (curNum == nums[i]) {
                continue;
            }
            nums[result++] = nums[i];
            curNum = nums[i];
        }
        return result;
    }
}