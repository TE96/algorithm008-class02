package dp;

import java.util.Arrays;

public class MinimumPathSum {

    public int minPathSumOptSpace(int[][] grid) {
        if (grid == null || grid.length == 0) { return 0; }
        int row = grid.length, col = grid[0].length;
        // dp[i][j]表示走到i,j格子最小路径和
        int[] dp = new int[col];
        // 初始化
        Arrays.fill(dp, 0);
        dp[0] = grid[0][0];
        for (int i = 1; i < col; i ++) {
            dp[i] += dp[i - 1] + grid[0][i];
        }

        for (int i = 1; i < row; i ++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < col; j ++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[col - 1];
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) { return 0; }
        int row = grid.length, col = grid[0].length;
        // dp[i][j]表示走到i,j格子最小路径和
        int[][] dp = grid;
        // 初始化
        for (int i = 1; i < col; i ++) {
            dp[0][i] += dp[0][i - 1];
        }
        for (int i = 1; i < row; i ++) {
            dp[i][0] += dp[i - 1][0];
        }
        for (int i = 1; i < row; i ++) {
            for (int j = 1; j < col; j ++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }
}
