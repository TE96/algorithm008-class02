package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversalStackWithOnlyRightChild(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    res.add(cur.val);
                    stack.addLast(cur.right);
                    cur = cur.left;
                }
                else {
                    cur = stack.removeLast();
                }
            }
        }
        return res;
    }

    public List<Integer> preorderTraversalIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        TreeNode cur = root;
        while (!stack.isEmpty()) {
            cur = stack.removeLast();
            if (cur != null) {
                res.add(cur.val);
                stack.addLast(cur.right);
                stack.addLast(cur.left);
            }
        }
        return res;
    }

    public List<Integer> preorderTraversalRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        preorder(root, res);
        return res;
    }
    private void preorder(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            preorder(node.left, list);
            preorder(node.right, list);
        }
    }
}
