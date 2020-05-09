package greedy;

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; i < g.length && j < s.length; j ++) {
            if (g[i] <= s[j]) {
                i ++;
            }
        }
        return i;
    }

//    public int findContentChildren(int[] g, int[] s) {
//        Arrays.sort(g);
//        Arrays.sort(s);
//        int i = 0, j = 0, count = 0;
//        while (i < g.length && j < s.length) {
//            if (g[i] <= s[j]) {
//                i ++; j ++;
//                count ++;
//            }
//            else if (g[i] > s[j]) {
//                j ++;
//            }
//        }
//        return count;
//    }
}
