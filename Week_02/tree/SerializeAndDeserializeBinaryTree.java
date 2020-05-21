package tree;

import java.util.Arrays;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serialize(root, new StringBuilder()).toString();
    }

    private StringBuilder serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("n,");
        }
        else {
            sb.append(String.valueOf(root.val));
            sb.append(",");
            // s + 左子树
            sb = serialize(root.left, sb);
            // s + 左子树 + 右子树
            sb = serialize(root.right, sb);
        }
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] list = data.split(",");
        return deserialize(new LinkedList<>(Arrays.asList(list)));
    }
    private TreeNode deserialize(LinkedList<String> data) {
        String value = data.removeFirst();
        if ("n".equals(value)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = deserialize(data);
        root.right = deserialize(data);
        return root;
    }
}
