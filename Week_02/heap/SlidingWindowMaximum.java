package heap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    /**
     * 时间复杂度: 均摊O(n)
     * 空间复杂度: O(n)
     */
    public int[] maxSlidingWindowWithDeque(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        int[] result = new int[n - k + 1];
        int index = 0;
        // 保存索引
        Deque<Integer> window = new ArrayDeque<>();
        for (int i = 0; i < n; i ++) {
            // 移除窗口外的索引
            while (!window.isEmpty() && window.getFirst() < i - k + 1) {
                window.removeFirst();
            }
            // 移除窗口内比最大值小的索引
            while (!window.isEmpty() && nums[window.getLast()] < nums[i]) {
                window.removeLast();
            }
            window.addLast(i);
            if (i - k + 1 >= 0) {
                result[index++] = nums[window.getFirst()];
            }
        }
        return result;
    }
    /**
     * 时间复杂度: O(n*k)
     * 空间复杂度: O(n)
     */
    public int[] maxSlidingWindowWithHeap(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        int[] result = new int[n - k + 1];

        PriorityQueue<Integer> window = new PriorityQueue<>((n1, n2) -> n2 - n1);

        for (int i = 0; i < n; i ++) {
            int start = i - k;
            if (start >= 0) {
                window.remove(nums[start]);
            }
            window.add(nums[i]);
            if (window.size() == k) {
                result[i - k + 1] = window.peek();
            }
        }
        return result;
    }

    /**
     * 时间复杂度: O(n*k)
     * 空间复杂度: O(n)
     */
    public int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        int[] res = new int[n - k + 1];
        int index = 0;
        // 遍历每个窗口
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[index++] = max;
        }
        return res;
    }
}
