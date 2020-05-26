package dp;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rowSize = triangle.size();
        int lastRowSize = triangle.get(rowSize - 1).size();
        int[] dp = new int[lastRowSize];
        // 用三角形的最后一行初始化数组
        for (int i = 0; i < lastRowSize; i ++) {
            dp[i] = triangle.get(rowSize - 1).get(i);
        }
        for (int i = rowSize - 2; i >= 0; i --) {
            // 需要计算的数量就是当前行的元素数量
            for (int j = 0; j <= i; j ++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}
