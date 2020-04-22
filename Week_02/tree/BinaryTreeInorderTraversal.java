package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversalIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.addLast(cur);
                    cur = cur.left;
                }
                cur = stack.removeLast();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }


    public List< Integer > inorderTraversalRecursion(TreeNode root) {
        List < Integer > res = new ArrayList< >();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            // 这里root已经不为null, 若左右子树为null
            // 则递归调用什么都不做
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }
}
