import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsetsEnumerate(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i ++) {
                List<Integer> newSub = new ArrayList<>(result.get(i));
                newSub.add(num);
                result.add(newSub);
            }

        }
        return result;
    }

    public List<List<Integer>> subsetsBacktrack(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
