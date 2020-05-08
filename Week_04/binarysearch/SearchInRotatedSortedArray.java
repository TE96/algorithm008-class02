package binarysearch;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int num = nums[mid];
            // If nums[mid] and target are "on the same side" of nums[0], we just take nums[mid].
            if ((nums[mid] < nums[0]) != (target < nums[0])) {
                num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            if (num == target) {
                return mid;
            }
            else if (num < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public int searchBruteForce(int[] nums, int target) {
        if (nums.length == 1 && target == nums[0]) {
            return 0;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (target == nums[i]) {
                return i;
            }
            if (i > 0 && nums[i] > nums[i - 1] && target == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}