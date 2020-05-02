import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0 || k == 0) {
            return result;
        }
        combine(n, k, 1, result, new ArrayList<>());
        return result;
    }
    private void combine(int n, int k, int depth, List<List<Integer>> result, List<Integer> tmp) {
        if (tmp.size() == k) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = depth; i <= n; i ++) {
            tmp.add(i);
            combine(n, k, i + 1, result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
