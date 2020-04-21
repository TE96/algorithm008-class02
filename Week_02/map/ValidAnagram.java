package map;

public class ValidAnagram {
    /**
     * 数组下标映射法,
     * 遍历第第二个字符串时通过特殊判断从而不需要第三次遍历
     * 时间复杂度: O(n+n)=O(n)
     * 空间复杂度: O(1), 数组大小固定为26, 与字符串长度无关
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (char c : s.toCharArray()) {
            table[c - 'a'] ++;
        }
        for (char c : t.toCharArray()) {
            if (table[c - 'a'] == 0) {
                return false;
            }
            table[c - 'a'] --;
        }
        return true;
    }
}
