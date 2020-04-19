package array;

/**
 * 思路：
 * 用一个变量j维护下一个非零元素的插入位置
 * 当前元素的最终位置要么在当前位置前，要么就是当前位置
 * 不存在被覆盖的情况
 * 插入完成后需要补零
 * @author fuwuchen
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}
