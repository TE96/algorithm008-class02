import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        permute(nums, 0, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }
    private void permute(int[] nums, int level, List<List<Integer>> result, List<Integer> tmp, boolean[] used) {
        int n = nums.length;
        // terminator
        if (tmp.size() == n) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        // process
        for (int i = 0; i < n; i ++) {
            if (used[i] == false) {
                tmp.add(nums[i]);
                used[i] = true;
                permute(nums, i + 1, result, tmp, used);
                // reverse
                tmp.remove(tmp.size() - 1);
                used[i] = false;
            }
        }
    }
}
