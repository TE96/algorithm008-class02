import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, String> map = getMap();
        search(0, "", result, digits, map);
        return result;
    }
    private void search(int level, String s, List<String> result, String digits, Map<Character, String> map) {
        // terminator
        if (level == digits.length()) {
            result.add(s);
            return;
        }
        // process
        String letters = map.get(digits.charAt(level));
        for (Character c : letters.toCharArray()) {
            search(level + 1, s + c, result, digits, map);
        }
        // reverse
    }
    private Map<Character, String> getMap() {
        HashMap<Character, String> map = new HashMap<>(8);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }
}
