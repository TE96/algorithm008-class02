package tree;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {



    public int minDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        stack.addLast(new Pair<>(root, 1));
        int depth = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.removeLast();
            TreeNode node = pair.getKey();
            int currentDepth = pair.getValue();
            if (node.left == null && node.right == null) {
                depth = Math.min(depth, currentDepth);
            }
            if (node.left != null) {
                stack.addLast(new Pair<>(node.left, currentDepth + 1));
            }
            if (node.right != null) {
                stack.addLast(new Pair<>(node.right, currentDepth + 1));
            }
        }
        return depth;
    }

    public int minDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 1));
        int currentDepth = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            currentDepth = pair.getValue();
            if (node.left == null && node.right == null) {
                break;
            }
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, currentDepth + 1));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, currentDepth + 1));
            }
        }
        return currentDepth;
    }

    public int minDepthRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepthRecursion(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepthRecursion(root.right), min);
        }
        return min + 1;
    }
}
