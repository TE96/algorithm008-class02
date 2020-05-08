package binarysearch;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length -1 ]) {
            return nums[0];
        }
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}
