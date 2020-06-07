package unionfind;

public class SurrounedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int[][] dir = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
        int row = board.length;
        int col = board[0].length;
        // 最后一个为dummy node
        UnionFind uf = new UnionFind(row * col + 1);
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                boolean isEdge = i == 0 || i == row - 1 || j == 0 || j == col - 1;
                if (isEdge && board[i][j] == 'O') {
                    // 如果O在边界上, 连接到dummy node
                    uf.union(i * col + j, row * col);
                } else if (board[i][j] == 'O') {
                    for (int[] d : dir) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (board[x][y] == 'O') {
                            uf.union(i * col + j, x * col + y);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (!uf.isConnected(i * col + j, row * col)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    class UnionFind {
        private int[] parent;
        private int[] rank;
        public UnionFind(int total) {
            parent = new int[total];
            rank = new int[total];
            for (int i = 0; i < total; i ++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q) {
            int i = find(p);
            int j = find(q);
            if (i != j) {
                // parent[i] = j;
                if (rank[i] < rank[j]) {
                    parent[i] = j;
                }
                else if (rank[i] > rank[j]) {
                    parent[j] = i;
                }
                else {
                    parent[j] = i;
                    rank[i] ++;
                }
            }
            // count --;
        }
        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }
}
