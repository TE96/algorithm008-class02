package heap;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequentWithBucket(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int num : count.keySet()) {
            int freq = count.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }
        int[] res = new int[k];
        // 可以按任意顺序返回答案
        for (int i = bucket.length - 1; i >= 0 && k > 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size(); j++) {
                    res[--k] = bucket[i].get(j);
                }
            }
        }
        return res;

        // List<Integer> to int[]
        // List<Integer> res = new ArrayList<>();
        // for (int i = bucket.length - 1; i >= 0 && k > 0; i--) {
        //     if (bucket[i] != null) {
        //         res.addAll(bucket[i]);
        //     }
        // }
        // return res.subList(0, k).stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] topKFrequentWithHeap(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (count.get(b) - count.get(a)));
        for (int num : count.keySet()) {
            pq.offer(num);
        }
        int[] res = new int[k];
        // 可以按任意顺序返回答案
        while (k > 0) {
            res[--k] = pq.poll();
        }
        return res;
    }
}
