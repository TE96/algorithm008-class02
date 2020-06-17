package string;

import java.util.HashSet;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> jewels = new HashSet<>();
        for (char j : J.toCharArray()) {
            jewels.add(j);
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            if (jewels.contains(c)) {
                count ++;
            }
        }
        return count;
    }
}
