package array;

/**
 * 思路：
 *
 * @author fuwuchen
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverseList(nums, 0, n - 1);
        reverseList(nums, 0, k - 1);
        reverseList(nums, k, n - 1);
    }
    private void reverseList(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
