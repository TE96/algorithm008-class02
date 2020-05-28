package dp;

public class MaximumProductSubarray {

    public int maxProductSimplified(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        /*
         * fmax(i) = max(fmax(i-1) * a[i], fmin(i-1) * a[i], a[i])
         * fmin(i) = min(fmax(i-1) * a[i], fmin(i-1) * a[i], a[i])
         */
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            int prevMax = max, prevMin = min;
            max = Math.max(prevMax * nums[i], Math.max(prevMin * nums[i], nums[i]));
            min = Math.min(prevMin * nums[i], Math.min(prevMax * nums[i], nums[i]));
            res = Math.max(res, max);
        }
        return res;
    }
}
