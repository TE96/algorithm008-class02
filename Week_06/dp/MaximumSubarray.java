package dp;

public class MaximumSubarray {

    public int maxSubArrayOptSpace(int[] nums) {
        int prevMax = 0, max = nums[0];
        for (int num : nums) {
            prevMax = Math.max(prevMax, 0) + num;
            max = Math.max(prevMax, max);
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0]; dp[0] = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
