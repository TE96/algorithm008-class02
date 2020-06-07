package advsearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, n, result, "");
        return result;
    }
    private void dfs(int left, int right, List<String> result, String temp) {
        // 剪枝
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, result, temp + "(");
        }
        if (right > 0) {
            dfs(left, right - 1, result, temp + ")");
        }
        if (left == 0 && right == 0) {
            result.add(temp);
            // return;
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<String>();
        if (n <= 0) {
            return res;
        }

        dfs(res, "", n, 0);

        return res;
    }

    public void dfs(List<String> res, String s, int n, int count) {
        if (n == 0 && count == 0) {
            res.add(s);
            return;
        }
        if (n < 0) {
            return;
        }
        if (count < 0) {
            return;
        }

        dfs(res, s + "(", n - 1, count + 1);
        dfs(res, s + ")", n, count - 1);

        // return;
    }

}
