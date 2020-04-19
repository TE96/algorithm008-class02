package array;

/**
 * 思路：
 * 考虑两个端点不断往里夹逼的过程
 * 由于面积 = 坐标差 × 端点高度较小值,
 * 可以记录从坐标差最大开始的面积的最大值。
 * 注：比较过程中可以跳过一些不用计算的情况
 * @author fuwuchen
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i <= j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight;
            max = Math.max(area, max);
        }
        return max;
    }
}
