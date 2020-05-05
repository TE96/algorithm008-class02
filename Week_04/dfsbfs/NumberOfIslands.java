package dfsbfs;

public class NumberOfIslands {
    private int rowLength;
    private int colLength;
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0) {
            return count;
        }
        rowLength = grid.length;
        colLength = grid[0].length;
        for (int i = 0; i < rowLength; i ++) {
            for (int j = 0; j < colLength; j ++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count ++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= rowLength || j >= colLength || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
