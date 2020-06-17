package advdp;

public class MinCostClimbingStairs {

    public int minCostClimbingStairsOpt(int[] cost) {
        int pre = 0, prePre = 0;
        int minCost = 0;
        for (int i = 0; i < cost.length - 1; i ++) {
            minCost = Math.min(pre + cost[i + 1], prePre + cost[i]);
            prePre = pre;
            pre = minCost;
        }
        return minCost;
    }

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i ++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
        return Math.min(dp[len - 2], dp[len - 1]);
    }
}
