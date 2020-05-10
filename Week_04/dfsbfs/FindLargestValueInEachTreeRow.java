package dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValuesBFS(TreeNode root) {
        List<Integer> result = new ArrayList<>(10);
        if (root == null) { return result; }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode cur = queue.poll();
                max = Math.max(max, cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(max);
        }
        return result;
    }

    public List<Integer> largestValuesDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) { return result; }
        dfs(root, 0, result);
        return result;
    }
    private void dfs(TreeNode root, int level, List<Integer> result) {
        if (root == null) { return; }
        if (result.size() == level) {
            result.add(root.val);
        }
        result.set(level, Math.max(result.get(level), root.val));
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }
}
