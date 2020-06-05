package unionfind;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0
                || grid[0].length == 0) {
            return 0;
        }
        int[][] dir = { {1,0}, {-1,0}, {0,1}, {0,-1} };
        int row = grid.length;
        int col = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (grid[i][j] == '1') {
                    for (int[] d : dir) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {
                            int id1 = i * col + j;
                            int id2 = x * col + y;
                            uf.union(id1, id2);
                        }
                    }
                }
            }
        }
        return uf.count;
    }

    class UnionFind {
        public int count;
        public int[] parent;
        public int[] rank;

        public UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; i ++) {
                for (int j = 0; j < n; j ++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count ++;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
                rank[rootP] += rank[rootQ];
            }
            else {
                parent[rootP] = rootQ;
                rank[rootQ] += rank[rootP];
            }
            count --;
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
    }
}
