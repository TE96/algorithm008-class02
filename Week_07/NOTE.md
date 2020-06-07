# 学习笔记

## Trie代码模板

```java
class Trie {
    private boolean isEnd;
    private Trie[] next;
    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) curr.next[n] = new Trie();
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}
```

## 并查集代码模板

```java
class UnionFind {
    private int count = 0;
    private int[] parent;
    
    public UnionFind(int n) {
        this.count = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i ++) {
            this.parent[i] = i;
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
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        count --;
    }
}
```

## 双向BFS代码模板

```java
void biBfs() {
    Set<T> left = new LinkedList<>();
    Set<T> right = new LinkedList<>();
    Set<T> remain = new HashSet<>(list);
    left.add(start);
    right.add(end);
    
    // set some flag
    // example: count = 0;
    
    while (!left.isEmpty() && !right.isEmpty()) {
        if (left.size() > right.size) {
            // left -> right -> left -> right
            swap(left, right);
        }
        remain.removeAll(left);
        Set<T> next = new LinkedList<>();
        for (Node node : left) {
            // do something
            for (Node newNode : generateNextLevel()) {
                // node must in the path given by question
                if (remain.contains(newNode)) {
                    if (newNode == end) {
                        return;
                    }
                    next.add(newNode);
                }
            }
        }
        left = next;
        // do something: 
        // example: count++;
    }
}
```

## 单词搜索2 时间复杂度分析

该题使用Trie实现的代码如下：

```java
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

```

这里设定`board`的行数为`m`，列数为`n`，单词个数为`k`，单词平均长度为`l`，最大长度为`L`

其中，主函数`findWords`的复杂度有两大部分组成：

- 构建字典树`buildTrie`
- 两层`for`循环

对两部分分别进行分析如下：

- 构建字典树：需要遍历单词和单词的每个字母，复杂度为$O(k * l)$

- 两层循环：
  - 循环内只有一个if语句及对应的dfs函数，极端情况下每次都要进入if语句，或者每次都不需要进入if语句，复杂度介于$O(m * n)$和$O(m * n) * O(dfs)$之间
  - `dfs`的目标是搜索由当前字母（前缀）开头的单词，其复杂度与单词的长度相关，由于可以从4个方向进行搜索，最差情况下第一次4个方向，之后3个方向都要进行搜索而不回溯，那么复杂度为$O(4 * 3^{L-1})$。

构建字典树相比两层循环的复杂度量级要低，所以整体复杂度取决于两层循环的复杂度。

综上，单词搜索的时间复杂度在$O(m * n)$和$O(m * n * 4 * 3^{L-1})$之间