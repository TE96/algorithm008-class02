package greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int end = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i --) {
            if (i + nums[i] >= end) {
                end = i;
            }
        }
        return end == 0;
    }

    public boolean canJumpBruteForce(int[] nums) {
        // 对每一位判断是否能跳到最后
        if (nums == null) {
            return false;
        }
        boolean[] reach = new boolean[nums.length];
        reach[0] = true;
        for (int i = 0; i < nums.length - 1; i ++) {
            if (reach[i]) {
                for (int j = i; j <= i + nums[i] && j < nums.length; j ++) {
                    reach[j] = true;
                }
            }
        }
        return reach[reach.length - 1];
    }
}
