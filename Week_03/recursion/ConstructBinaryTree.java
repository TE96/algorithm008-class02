package recursion;

import java.util.HashMap;

public class ConstructBinaryTree {
    private int[] preorder;
    private int[] inorder;
    private int startPre;
    private HashMap<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        this.preorder = preorder;
        this.inorder = inorder;
        this.startPre = 0;
        this.indexMap = new HashMap<>(preorder.length);
        for (int i = 0; i < inorder.length; i ++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(0, inorder.length);
    }
    private TreeNode buildTree(int startIn, int endIn) {
        // terminator
        if (startIn < endIn) {
            return null;
        }
        // process
        int rootVal = preorder[startPre];
        TreeNode root = new TreeNode(rootVal);
        // find root in inorder
        int rootIndex = this.indexMap.get(rootVal);
        // next root
        startPre ++;
        // recursion
        root.left = buildTree(startIn, rootIndex);
        root.right = buildTree(rootIndex + 1, endIn);
        return root;
    }
}
