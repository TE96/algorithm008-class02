package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NaryTreePreorderTraversal {


    public List<Integer> preorderIteration(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stack = new LinkedList<>();
        Node cur = root;
        stack.addLast(cur);
        while (!stack.isEmpty()) {
            cur = stack.removeLast();
            res.add(cur.val);
            for (int i = cur.children.size() - 1; i >= 0; i --) {
                stack.addLast(cur.children.get(i));
            }
        }
        return res;
    }

    private List<Integer> res = new ArrayList<>();
    public List<Integer> preorderRecursion(Node root) {

        if (root == null) {
            return res;
        }
        res.add(root.val);
        for (Node node : root.children) {
            preorderRecursion(node);
        }
        return res;
    }
}
