package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) { return result; }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i ++) {
            // 忽略重复值
            if (i > 0 && nums[i] == nums[i - 1]) { continue; }
            // 1层剪枝
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target) { break; }
            int max = nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1];
            if (max < target) { continue; }
            // 3数之和
            for (int j = i + 1; j < length - 2; j ++) {
                // 忽略重复值
                if (j > i + 1 && nums[j] == nums[j - 1]) { continue; }
                int k = j + 1, h = length - 1;
                // 2层剪枝
                int min1 = nums[i] + nums[j] + nums[k] + nums[k + 1];
                if (min1 > target) { continue; }
                int max1 = nums[i] + nums[j] + nums[h - 1] + nums[h];
                if (max1 < target) { continue; }
                // 枚举剩下两个指针
                while (k < h) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[h];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[h]));
                        k ++;
                        while (k < h && nums[k] == nums[k - 1]) { k ++; }
                        h --;
                        while (k < h && j < h && nums[h] == nums[h + 1]) { h --; }
                    }
                    else if (sum > target) { h --; }
                    else { k ++; }
                }
            }
        }
        return result;
    }

    // 对比非剪枝算法
    public List<List<Integer>> fourSumWithoutPruning(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) { return result; }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i ++) {
            // 忽略重复值
            if (i > 0 && nums[i] == nums[i - 1]) { continue; }
            // 3数之和
            for (int j = i + 1; j < length - 2; j ++) {
                // 忽略重复值
                if (j > i + 1 && nums[j] == nums[j - 1]) { continue; }
                int k = j + 1, h = length - 1;
                // 枚举剩下两个指针
                while (k < h) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[h];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[h]));
                        k ++;
                        while (k < h && nums[k] == nums[k - 1]) { k ++; }
                        h --;
                        while (k < h && j < h && nums[h] == nums[h + 1]) { h --; }
                    }
                    else if (sum > target) { h --; }
                    else { k ++; }
                }
            }
        }
        return result;
    }
}
