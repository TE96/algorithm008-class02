package array;

/**
 * 思路: 与MoveZeros类似
 * @author fuwuchen
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int j = 0;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[j] != nums[i]) {
                j ++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
