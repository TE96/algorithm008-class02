package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class NaryTreeLevelOrderTranversal {
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
                queue.addAll(cur.children);
            }
            res.add(level);
        }
        return res;
    }

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrderRecursion(Node root) {
        if (root == null) return result;
        traverse(root, 0);
        return result;
    }
    private void traverse(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for (Node children : node.children) {
            traverse(children, level + 1);
        }
    }
}
