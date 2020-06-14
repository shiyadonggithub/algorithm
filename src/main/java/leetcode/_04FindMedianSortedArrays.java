package leetcode;

public class _04FindMedianSortedArrays {
    public static void main(String[] args) {
        _04FindMedianSortedArrays findMedianSortedArrays = new _04FindMedianSortedArrays();
        System.out.println("res:" + findMedianSortedArrays.findMedianSortedArrays(new int[]{1, 2},
                new int[]{2, 3, 4,5,6}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            if (nums2.length % 2 == 0) {
                return (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0;
            }
            return nums2[nums2.length / 2] / 1.0;
        }
        if (nums2 == null) {
            if (nums1.length % 2 == 0) {
                return (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0;
            }
            return nums1[nums1.length / 2] / 1.0;
        }

        int len = nums1.length + nums2.length;
        int m = -1, n = -1;
        if (len % 2 != 0) {
            for (int i = 0; i <= len / 2; i++) {
                if (m < nums1.length - 1 && n < nums2.length - 1) {
                    if (nums1[m + 1] < nums2[n + 1]) {
                        m++;
                        if (i == len / 2) return nums1[m] / 1.0;
                    } else {
                        n++;
                        if (i == len / 2) return nums2[n] / 1.0;
                    }
                } else if (m >= nums1.length - 1) {
                    n++;
                    if (i == len / 2) return nums2[n] / 1.0;
                } else {
                    m++;
                    if (i == len / 2) return nums1[m] / 1.0;
                }
            }
        }

        int pre = 0, cur = 0;
        if (len % 2 == 0) {
            for (int i = 0; i <= len / 2; i++) {
                if (m < nums1.length - 1 && n < nums2.length - 1) {
                    if (nums1[m + 1] < nums2[n + 1]) {
                        m++;
                        pre = cur;
                        cur = nums1[m];
                    } else {
                        n++;
                        pre = cur;
                        cur = nums2[n];
                    }
                } else if (m >= nums1.length - 1) {
                    n++;
                    pre = cur;
                    cur = nums2[n];
                } else {
                    m++;
                    pre = cur;
                    cur = nums1[m];
                }
            }
        }
        return (pre + cur) / 2.0;
    }
}
