package leetcode;

public class _34findFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 7;
        _34findFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray = new _34findFirstAndLastPositionOfElementInSortedArray();
        int[] res = findFirstAndLastPositionOfElementInSortedArray.searchRange(nums,target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0)
            return res;
        int leftIndex = 0, rightIndex = nums.length-1;
        int begin = -1, end = -1;
        while (leftIndex <= rightIndex) {
            int middle = (leftIndex + rightIndex) / 2;
            if (nums[middle] == target) {
                int leftSearch = searchLeft(nums, leftIndex, middle - 1, target);
                begin = leftSearch == -1 ? middle : leftSearch;
                int rightSearch = searchRight(nums, middle + 1, rightIndex, target);
                end = rightSearch == -1 ? middle : rightSearch;
                res[0] = begin;
                res[1] = end;
                return res;
            }
            if (nums[middle] > target) {
                rightIndex = middle - 1;
            }
            if (nums[middle] < target) {
                leftIndex = middle + 1;
            }
        }
        return res;
    }

    private int searchLeft(int[] nums, int begin, int end, int target) {
        while (begin <= end) {
            int middle = (begin + end) / 2;
            if (nums[middle] == target) {
                int leftSearch = searchLeft(nums, begin, middle - 1, target);
                return leftSearch == -1 ? middle : leftSearch;
            }
            if (nums[middle] > target) {
                end = middle - 1;
            }
            if (nums[middle] < target) {
                begin = middle + 1;
            }
        }
        return -1;
    }

    private int searchRight(int[] nums, int begin, int end, int target) {
        while (begin <= end) {
            int middle = (begin + end) / 2;
            if (nums[middle] == target) {
                int rightSearch = searchRight(nums, middle + 1, end, target);
                return rightSearch == -1 ? middle : rightSearch;
            }
            if (nums[middle] > target) {
                end = middle - 1;
            }
            if (nums[middle] < target) {
                begin = middle + 1;
            }
        }
        return -1;
    }
}