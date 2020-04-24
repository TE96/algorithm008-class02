package tree;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxiumDepthOfBinaryTree {

    public int maxDepthDFSIteration(TreeNode root) {
        int depth = 0;
        if (root != null) {
            Deque<Pair<TreeNode, Integer>> stack = new LinkedList<>();
            stack.addLast(new Pair<>(root, 1));

            while (!stack.isEmpty()) {
                Pair<TreeNode, Integer> pair = stack.removeLast();
                TreeNode current = pair.getKey();
                int currentDepth = pair.getValue();
                if (current != null) {
                    depth = Math.max(depth, currentDepth);
                    stack.addLast(new Pair<>(current.left, currentDepth + 1));
                    stack.addLast(new Pair<>(current.right, currentDepth + 1));
                }
            }
        }
        return depth;
    }

    public int maxDepthDFSRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepthDFSRecursion(root.left);
        int right = maxDepthDFSRecursion(root.right);
        return Math.max(left, right) + 1;
    }

    public int maxDepthBFS(TreeNode root) {
        int depth = 0;
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                depth ++;
                for (int i = 0; i < size; i ++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }
        return depth;
    }
}
