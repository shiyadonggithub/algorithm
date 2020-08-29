package leetcode;

public class _11ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }


    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
            }
            for (; i < height.length - 1; i++) {
                if (height[i + 1] > height[i]) {
                    break;
                }
            }
        }
        return max;
    }
}
