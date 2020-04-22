package tree;

import java.util.PriorityQueue;

public class LeastKNumbers {
    public int[] getLeastNumbersWithHeap(int[] arr, int k) {
        if (arr.length == 0 || k== 0 || k > arr.length) {
            return new int[0];
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i ++) {
            heap.add(arr[i]);
        }
        int[] res = new int[k];
        int j = 0;
        for (int i = 0; i < k; i ++) {
            res[j++] = heap.remove();
        }
        return res;
    }
}
