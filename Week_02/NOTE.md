# 学习笔记

## 关于二叉树算法

树的算法建立在对树的遍历上，遍历方式有：前序、中序、后序、层序，这里先总结前序、中序和层序遍历。

### 递归算法

前、中、后序遍历在递归算法中的区别仅仅是语句的顺序不同

- 前序遍历：根、左、右
- 中序遍历：左、根、右
- 后序遍历：左、右、根

```Java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeTraversalRecursion {
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
}
```

### 非递归算法

非递归算法通常是自底向上的，而递归算法通常是自顶向下的。非递归算法需要更关注操作过程，从起点出发不断进行迭代，从而达到最终目的；而递归算法重视递推关系，从终点分解到基本情况，再返回回来。

前序遍历与中序遍历的区别在于，根节点与左子树的访问顺序相反，需要调整进栈顺序。

```Java
public class BinaryTreeTraversalIteration {
    public List<Integer> preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        TreeNode cur = root;
        while (!stack.isEmpty()) {
            // 这里出栈的是根节点
            cur = stack.removeLast();
            if (cur != null) {
                res.add(cur.val);
                stack.addLast(cur.right);
                stack.addLast(cur.left);
            }
        }
        return res;
    }
   
    public List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            // 区别1：先移动到最左作为起始位置
            while (cur != null) {
                stack.addLast(cur);
                cur = cur.left;
            }
            // 区别2：这里出栈的是左子树
            cur = stack.removeLast();
            res.add(cur.val);
            // 区别3：这里没有手动将右子树进栈，而是将访问完的根节点修改成右子树，
            // 从而进入下一次迭代
            cur = cur.right;
        }
        return res;
    }
}
```

## 关于堆排序

堆排序流程：

- 找出最大元素
- 将其放置到最后
- 对其余元素重复上述过程

用数组表示二叉堆，可以很方便地找到父结点（ｉ / 2）或者左右儿子（2 × ｉ + 1、2 × ｉ+２，假定ｉ从０开始），因为堆是完全二叉树。

升序的堆排序算法：

1. 根据输入数据建立最大堆

2. 将最大元素根节点，和堆中下标为size - 1的元素互换，对堆顶做heapifyDown操作
3. 当堆的size大于1时，重复上述操作

代码如下：

```Java
public class HeapSort {
    public void sort(int arr[]) {
        int n = arr.length;
        // 1. 建立初始堆
        // 迭代算法是由已知推未知，只有在下层已成堆的情况下才能对上层进行堆化
        // 由于向下调整是对根的操作，因此从第一个非叶结点开始操作，也就是最后一个节点的父节点
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(arr, n, i);
        }
        // 2、3. 重复对最大元素进行交换操作
        // 此处复杂度为O(n)
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 调整堆，此处复杂度为O(logn)
            heapifyDown(arr, i, 0);
        }
    }
    void heapifyDown(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        // 如果左儿子较大，则根节点与左儿子交换
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        // 如果右儿子较大，则根节点与右儿子交换
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
            heapifyDown(arr, n, largest); 
        }
    }
}
```

## 

## 