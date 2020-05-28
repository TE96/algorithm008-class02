# 学习笔记

## 动态规划

数学归纳法思维（状态转移方程，DP方程）

寻找重复性 -> 递归状态树、重复子状态 

### 概念

- 动态规划（动态递推）和递归或者分治没有根本上的区别（关键看有无最优子结构）

- 共性：找到重复子问题，如果没有重复子问题则说明要计算所有子问题然后合并（分治）

- 差异性：最优子结构、中途可以淘汰次优解

### 解题思路

1. 暴力求解，查看是否有重复子问题

2. DP：

   a. 分治（子问题）

   b. 状态数组定义

   c. DP方程

通常DP有如下解法：

**Top-Bottom** 分治、记忆化，如将计算结果存储在数组中（递归）

```java
int fib (int n, int[] memo) {
    if (n <= 1) {
        return n;
    }
    if (memo[n] == 0) {
        // Memoization
        memo[n] = fib(n - 1) + fib(n - 2);
    }
    return memo[n];
}
```

**Bottom-Up** 设置初始值，循环递推

一维递推

```java
a[0] = 0, a[1] = 1;
for (int i = 2; i <= n; i ++) {
    a[i] = a[i-1] + a[i-2];
}
```

多维递推，取舍最优子结构

```java
public int uniquePaths(int m, int n) {
    int[][] grid = new int[n][m];
    // 设置初始值
    for (int i = 0; i < m; i ++) {
        grid[0][i] = 1;
    }
    for (int i = 0; i < n; i ++) {
        grid[i][0] = 1;
    }
    for (int i = 1; i < n; i ++) {
        for (int j = 1; j < m; j ++) {
            // 只能往下走或往右走
            grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
        }
    }
    return grid[n - 1][m - 1];
}
```

空间优化，滚动数组（二维 -> 一维）

```java
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int width = obstacleGrid[0].length;
    int[] dp = new int[width];
    // 设置初始值
    dp[0] = 1;
    for (int[] row : obstacleGrid) {
        for (int i = 0; i < width; i ++) {
            // 有障碍物
            if (row[i] == 1) {
                dp[i] = 0;
            }
            else if (i > 0) {
                // 原本的dp[i]就是上一格的值
                dp[i] += dp[i - 1];
            }
        }
    }
    return dp[width - 1];
}
```


### 关键点

1. 最优子结构 `opt[n] = best_of(ope[n-1], opt[n-2], ...)`
2. 定义、存储中间状态：`opt[i]`（关键步骤）
3. 递推公式（状态转移方程，竞赛中是难点）
   - Fib: `opt[n-1] + opt[n-2]`
   - 二维路径: `opt[i,j] = opt[i+1][j] + opt[i][j+1]`，根据情况判断是否能到达

**5 "easy" steps to DP**

1. define subproblems，进行分治，把当前复杂问题转换为简单子问题
2. guess (part of solution)，递推方程
3. relate subproblem solutions，合并子问题的解
4. recurse & memoize or build DP table bottom-up
5. solve original problem

### 例题

路径计数：

- 重复性：当前格子只能从左或上走到，`problem[i,j] = sub[i-1,j] + sub[i,j-1]`

- 状态定义：`dp[i][j]`表示走到`i, j`位置有多少条路径
- DP方程：`dp[i][j] = dp[i-1][j] + dp[i][j-1]`，

最长公共子序列（LCS）：

- 状态定义
  - 基本情况：
    - `S1 = ""`与任意字符串S2的LCS为空
    - `S1 = "A"`（任意字母）与任意字符串S2的LCS为0或1
    - `S1=".....A"，S2="...A"`，有相同结尾的字符串（通常从最后看起来识别子问题），`LCS`为子序列`LCS + 1`
  - 二维数组行和列表示两个字符串（注意下标从1开始），`dp[i][j]`表示子串`text1[0..i]`和子串`text2[0..j]`最长公共子序列的长度

- DP方程:

  ```python
  if S1[-1] != S2[-1]:
      # 当前字符不等, 结果为各自去掉一个字符中较大的
      LCS[S1, S2] = Max(LCS[S1-1, S2], LCS[S1, S2-1])
      # LCS[S1, S2] = Max(LCS[S1-1, S2], LCS[S1, S2-1], LCS[S1-1, S2-1])
  if S1[-1] == S2[-1]:
      # 当前字符相等, 结果为去掉当前字符的子串 +１
      LCS[S1, S2] = LCS[S1-1, S2-1] + 1
      # LCS[S1, S2] = LCS[S1, S2] = Max(LCS[S1-1, S2], LCS[S1, S2-1], LCS[S1-1, S2-1], LCS[S1-1][S2-1] + 1)
  
  ```

爬楼梯问题：

- 重复性：当前楼梯只能从后面1阶或者后面2阶到达

- 状态定义：同斐波那契数
- DP方程：`F(n) = F(n-1) + F(n-2)`
- 拓展：相邻两步的步伐不能相同

三角形最小路径和：

- 重复性：`problem(i, j) = min(sub(i+1, j), sub(i+1, j+1)) + a[i][j]`

- 状态定义：`f[i][j]`为走到最后一行的最小路径和， 优化时可以考虑滚动数组
- DP方程：`f(i, j) = min(f(i+1, j), f(i+1, j+1)) + a[i][j]`

最大子序和

- 重复性：如果选第`i`个元素，则最大子序列`max_sum(i) = max(max_sum(i-1), 0) + a[i]`，即包含/不包含前一个数的子序和中较大值加上自己
- 状态定义：`f[i]`表示从`0`到`i`个元素且包括`i`的累加和
- DP方程：`f[i] = max(f(i-1), 0) + a[i]`，遍历数组，如果累加和为负数则丢弃累加和

零钱兑换

- 重复性：类似爬楼梯，假设要凑齐11的面值，有1\2\5可选，则`problem(11) = sub(11-1) + sub(11-2) + sub(11-5)`，暴力求解找硬币数量最小就是递归层次最小，可以做BFS
- 状态定义：`f(i)`为凑到面值为`i`所需要的最小硬币数
- DP方程：`f(n) = min(f(n-k), for k in [1, 2, 5]) + 1`，k为可选面值