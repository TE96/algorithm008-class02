package greedy;

public class JumpGame2 {

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public int jump(int[] nums) {
        int result = 0;
        int end = 0, maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i ++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                result ++;
            }
        }
        return result;

    }

    /**
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     */
    public int jump1(int[] nums) {
        int step = 0;
        int position = nums.length - 1;
        while (position > 0) {
            for (int i = 0; i < position; i ++) {
                if (i + nums[i] >= position) {
                    position = i;
                    step ++;
                    break;
                }
            }
        }
        return step;
    }
}
