package dp;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        // 递推amount
        for (int i = 1; i < max; i ++) {
            // 枚举所有面值
            for (int coin : coins) {
                // 如果当前面值可以从当前amount中减去
                if (i >= coin) {
                    // dp[i] = min(dp[i-1], dp[i-2], dp[i-5]) + 1;
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[max - 1] > amount ? -1 : dp[max - 1];
    }
}
