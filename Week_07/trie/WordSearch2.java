package trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    private char[][] board;
    private boolean[][] visited;
    private int[][] dir = new int[][] { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

    private List<String> result;

    private int rowLength;
    private int colLength;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.rowLength = board.length;
        this.colLength = board[0].length;
        this.visited = new boolean[rowLength][colLength];
        this.result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < rowLength; i ++) {
            for (int j = 0; j < colLength; j ++) {
                // find the initial letter
                if (root.next[board[i][j] - 'a'] != null) {
                    // find the rest
                    dfs(i, j, root);
                }
            }
        }
        return result;
    }
    private void dfs(int i, int j, TrieNode root) {
        // terminator
        if (i < 0 || i >= rowLength
                || j < 0 || j >= colLength) {
            return;
        }
        char ch = board[i][j];
        // is visited or prefix is not in trie
        if (visited[i][j] || root.next[ch - 'a'] == null) {
            return;
        }
        // prefix is in trie
        root = root.next[ch - 'a'];
        if (root.word != null) {
            result.add(root.word);
            // de-duplicate
            root.word = null;
        }
        // current level
        visited[i][j] = true;
        // next level
        for (int k = 0; k < 4; k ++) {
            dfs(i + dir[k][0], j + dir[k][1], root);
        }
        // reverse state
        visited[i][j] = false;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char ch : word.toCharArray()) {
                if (p.next[ch - 'a'] == null) {
                    p.next[ch - 'a'] = new TrieNode();
                }
                p = p.next[ch - 'a'];
            }
            // word end
            p.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
