package map;

public class ValidAnagram {
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
