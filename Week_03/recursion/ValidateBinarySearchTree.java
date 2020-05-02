package recursion;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ValidateBinarySearchTree {

    long prev = Long.MIN_VALUE;
    boolean result = true;

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 中序遍历二叉搜索树, 如果发现序列不是严格递增的, 则返回false
     */
    public boolean isValidBSTInorder(TreeNode root) {
        if (root == null) {
            return result;
        }
        result = isValidBSTInorder(root.left);
        if (root.val <= prev) {
            return false;
        }
        prev = root.val;
        result = result && isValidBSTInorder(root.right);
        return result;
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 用long的原因是当只有一个根节点且值为Integer.MAX_VALUE时判断会出错
     */
    public boolean isValidBSTRecursion(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        if (root.val <= left || root.val >= right) {
            return false;
        }
        return isValidBST(root.left, left, root.val) && isValidBST(root.right, root.val, right);
    }
}
