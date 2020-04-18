import java.util.*;

/**
 * 思路：
 * 对数组进行排序，通过3个指针枚举3个数
 * 固定最左（最小）数的位置k，枚举另外两个数的位置i, j，有nums[k] <= nums[i] <= nums[j]
 * 因此如果nums[k] > 0，三数之和不可能为0，结束算法；
 * 如果三数之和大于0，说明三者中的最大数太大，故右边界往里缩，反之亦然
 * 注：
 * 在枚举最小元素nums[k]时需要跳过重复的元素，
 * 在得到一组解后需要跳过重复的nums[i]和nums[j]（此时重复的nums[k]已经跳过）
 * @author fuwuchen
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length; List<List<Integer>> res = new ArrayList<>();
        if (n < 3) return res;
        Arrays.sort(nums);
        for (int k = 0; k < n - 2; k ++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = n - 1;
            while (i < j) {
                int s = nums[k] + nums[i] + nums[j];
                if (s == 0) {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[i + 1]) i ++;
                    while (i < j && nums[j] == nums[j - 1]) j --;
                    i ++; j --;
                }
                else if (s < 0) i ++;
                else j --;
            }
        }
        return res;
    }
}
