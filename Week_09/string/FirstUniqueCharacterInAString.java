package string;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        // HashMap<Character, Integer> map = new HashMap<>();
        // char[] chars = s.toCharArray();
        // for (char c : chars) {
        //     map.put(c, map.getOrDefault(c, 0) + 1);
        // }
        // for (int i = 0; i < chars.length; i ++) {
        //     if (map.get(chars[i]) == 1) {
        //         return i;
        //     }
        // }
        // return -1;

        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] hash = new int[26];
        for (int i = 0; i < 26; i ++) {
            hash[i] = 0;
        }
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            hash[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i ++) {
            if (hash[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        int min = s.length();
        for(char c = 'a'; c <= 'z';c++) {
            int idx = s.indexOf(c);
            if(idx >= 0 && idx == s.lastIndexOf(c)) {
                min = Math.min(min, idx);
            }
        }
        return min == s.length() ? -1 : min;

    }
}
