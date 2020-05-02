package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generateParenthesis(0, 0, n, "");
        return result;
    }
    public void generateParenthesis(int left, int right, int n, String s) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }
        if (left < n) {
            generateParenthesis(left + 1, right, n, s + '(');
        }
        if (right < left) {
            generateParenthesis(left, right + 1, n, s + ')');
        }
    }
}
