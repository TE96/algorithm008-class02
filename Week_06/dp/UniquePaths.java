package dp;

import java.util.Arrays;

public class UniquePaths {

    public int uniquePathsLessSpace(int m, int n) {
        int[] grid = new int[m];
        Arrays.fill(grid, 1);
        for (int i = 1; i < n; i ++) {
            for (int j = 1; j < m; j ++) {
                grid[j] += grid[j - 1];
            }
        }
        return grid[m - 1];
    }

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[n][m];
        for (int i = 0; i < m; i ++) {
            grid[0][i] = 1;
        }
        for (int i = 0; i < n; i ++) {
            grid[i][0] = 1;
        }
        for (int i = 1; i < n; i ++) {
            for (int j = 1; j < m; j ++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
        return grid[n - 1][m - 1];
    }

    int[][] dp = new int[101][101];
    public int uniquePathsTopDown(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }
        // 计算过一次之后保存下来
        if (dp[n][m] == 0) {
            dp[n][m] = uniquePathsTopDown(m - 1, n) + uniquePathsTopDown(m, n - 1);
        }
        return dp[n][m];
    }
}
