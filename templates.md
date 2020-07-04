# 常用代码模板

## 哨兵

```java
public void moveZeroes(int[] nums) 
    // 设置哨兵
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            nums[j] = nums[i];
            j ++;
        }
    }
    while (j < nums.length) {
        nums[j] = 0;
        j ++;
    }
}
```

## 树的遍历

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeTraversalRecursion {
    // 中序遍历
    public List< Integer > inorder(TreeNode root) {
        List < Integer > res = new ArrayList< >();
        inorder(root, res);
        return res;
    }
    private void inorder(TreeNode root, List < Integer > res) {
        if (root != null) {
            // 这里root已经不为null, 若左右子树为null
            // 则递归调用什么都不做
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }
    }
    // 前序遍历
    public List< Integer > preorder(TreeNode root) {
        List < Integer > res = new ArrayList< >();
        preorder(root, res);
        return res;
    }
    private void preorder(TreeNode root, List < Integer > res) {
        if (root != null) {
            res.add(root.val);
            preorder(root.left, res);
            preorder(root.right, res);
        }
    }
    // 后序遍历
    public List< Integer > postorder(TreeNode root) {
        List < Integer > res = new ArrayList< >();
        postorder(root, res);
        return res;
    }
    private void postorder(TreeNode root, List < Integer > res) {
        if (root != null) {
            // 这里root已经不为null, 若左右子树为null
            // 则递归调用什么都不做
            postorder(root.left, res);
            postorder(root.right, res);
            res.add(root.val);
        }
    }
    // 层序遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // 当前queue中保存了一层中的所有节点
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
```

## 归并思想

```javascript
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    while (l1 != null && l2 != null) {
        if (l1.val > l2.val) {
            prev.next = l2;
            l2 = l2.next;
        }
        else {
            prev.next = l1;
            l1 = l1.next;
        }
        prev = prev.next;
    }
    if (l1 != null) { prev.next = l1; }
    if (l2 != null) { prev.next = l2; }
    return dummy.next;
}

public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
    if (l1 == null) { return l2; }
    else if (l2 == null) { return l1; }
    else if (l1.val < l2.val) {
        l1.next = mergeTwoListsRecursive(l1.next, l2);
        return l1;
    }
    else {
        l2.next = mergeTwoListsRecursive(l1, l2.next);
        return l2;
    }
}
```

## 快速排序分区

```java
public int partition(int[] A, int low, int high) {
    int pivot = A[low];
    while (low < high) {
        while (low < high && A[high] >= pivot) { -- high; }
        // 比枢纽小的值移动到左端
        A[low] = A[high];
        while (low < high && A[low] <= pivot) { ++ low; }
        // 比枢纽大的值移动到右端
        A[high] = A[low];
    }
    A[low] = pivot;
    // 返回存放枢纽的最终位置
    return low;
}
```

## 递归

```java
public void recur(int level, int param) {
    // terminator
    if (level > MAX_LEVEL) {
        // process result
        return;
    }
    
    // process current logic
    process(level, param);
    
    // drill down
    recur(level: level + 1, newParam);
    
    // restore current status
}
```

## 分治

```python
def divide_conquer(problem, param1, param2, ...):
    # recursion terminator
    if problem is None:
        print_result
        return
    
    # prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)
    
    # conquer subproblems
    subresult1 = self.divide_conquer(subproblems[0], p1, ...)
    subresult2 = self.divide_conquer(subproblems[1], p1, ...)
    subresult1 = self.divide_conquer(subproblems[2], p1, ...)
    ...
    
    # process and generate the final result
    result = process_result(subresult1, subresult2, subresult3, ...)
    
    # revert the current level states
```

## BFS

```python
def BFS(graph, start, end):
    visited = set()
   queue = [] 
   queue.append([start]) 

   while queue: 
      node = queue.pop() 
      visited.add(node)

      process(node) 
      nodes = generate_related_nodes(node) 
      queue.push(nodes)

   # other processing work 
   ...
```

## DFS

```python
visited = set() 

"""递归写法"""
def dfs(node, visited):
    if node in visited: # terminator
       # already visited 
       return 

   visited.add(node) 

   # process current node here. 
   ...
   for next_node in node.children(): 
      if next_node not in visited: 
         dfs(next_node, visited)

"""非递归写法"""
def DFS(self, tree): 

   if tree.root is None: 
      return [] 

   visited, stack = [], [tree.root]

   while stack: 
      node = stack.pop() 
      visited.add(node)

      process (node) 
      nodes = generate_related_nodes(node) 
      stack.push(nodes) 

   # other processing work 
   ...
```

## 二分查找

```python
left, right = 0, len(array) - 1 
while left <= right: 
    mid = (left + right) / 2 
    if array[mid] == target: 
        # find the target!! 
        break or return result 
    elif array[mid] < target: 
        left = mid + 1 
    else: 
        right = mid - 1
```

二分查找边界条件：

1. 中间索引mid可以写成`mid = left + (right - left) / 2 `防止整数溢出
2. 如果递增序列A有重复元素，需要找到第一个大于等于给定值x的位置L以及第一个大于x的位置R，即x的存在区间为左闭右开[L, R)，这两个问题都是在寻找有序序列中**第一个**满足某条件的元素位置（如果要寻找**最后一个**满足条件C的元素位置，可以先求第一个满足条件!C的元素位置，然后将位置-1），在进行比较时：
   - 求解L时（lower_bound问题）：
     - `A[mid] ≥ x`，则第一个≥x的元素一定在mid或mid左侧，继续查找有`right = mid`
     - `A[mid] < x`，则继续查找有`left = mid + 1`，由于没有等号，可以排除mid。
     - 循环条件为`left < right`，因为不需要假定x存在，当`left == right`时就是需要的结果，返回值可以选择其中一个
     - 二分查找的下界一定是0，上界根据问题判断是n还是n-1，如果要查询的元素可能比序列中所有元素都大，则选择n（此时n为应该在的位置）
   - 求解R时（upper_bound问题）：
     - `A[mid] > x`，则第一个大于x的元素一定在mid处或者mid左侧，继续查找有`right = mid`
     - `A[mid] ≤ x`时，则第一个大于x的元素一定在mid的右侧，继续查找有`left = mid + 1`
     - 循环条件与上面相同，`left == right`时就是要找的位置
     - 上下界和上面相同

## 动态规划

```java
// Top-Bottom 分治、记忆化，如将计算结果存储在数组中（递归）
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

// Bottom-Up 设置初始值，循环递推
// 一维递推
a[0] = 0, a[1] = 1;
for (int i = 2; i <= n; i ++) {
    a[i] = a[i-1] + a[i-2];
}


// 多维递推，取舍最优子结构
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

// 空间优化，滚动数组（二维 -> 一维）
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

## 并查集

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
            // 路径压缩
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

## 双向BFS

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

## Trie

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
    
    // 题目中
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
}
```