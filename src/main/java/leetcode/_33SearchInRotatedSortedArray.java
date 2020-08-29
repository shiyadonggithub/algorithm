package leetcode;

public class _33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        _33SearchInRotatedSortedArray searchInRotatedSortedArray = new _33SearchInRotatedSortedArray();

        int[] array = new int[]{4, 5, 6, 7, 8, 1, 2, 3};

        System.out.println(searchInRotatedSortedArray.search(array, 8));
    }

    public int search(int[] nums, int target) {
        int result = 0;

        if (nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1, middle = (left + right) / 2;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] == target)
                return middle;
            if (nums[middle] > nums[right] && nums[left] > target) {
                left = middle + 1;
                continue;
            }
            if (nums[middle] < nums[left] && nums[right] < target) {
                right = middle - 1;
                continue;
            }
            if (nums[middle] > target) {
                right = middle-1;
                continue;
            }
            left = middle+1;
        }

        return -1;
    }
}