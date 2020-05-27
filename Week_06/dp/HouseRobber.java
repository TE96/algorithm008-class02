package dp;

public class HouseRobber {

    public int robOpt2(int[] nums) {
        // prevMax 从前一个房子能偷到的最大值
        // f(k) = max(f(k – 2) + A[k], f(k – 1))
        int prevMax = 0, currMax = 0;
        for (int num : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + num, currMax);
            prevMax = temp;
        }
        return currMax;
    }

    public int robOpt1(int[] nums) {
        // nums[i]必偷的最大值
        int[] dp = new int[nums.length];
        if (nums.length == 0) { return 0; }
        if (nums.length == 1) { return nums[0]; }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int res = dp[1];
        for (int i = 2; i < nums.length; i ++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        // dp[i][0, 1]: 0不偷, 1偷
        int n = nums.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < n; i ++) {

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];

        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
