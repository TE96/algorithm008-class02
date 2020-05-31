package dp;

public class DecodeWays {

    public int numDecodingsOpt(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        char[] codes = s.toCharArray();
        int n = codes.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = codes[0] == '0' ? 0 : 1;
        for (int i = 2; i <= n; i ++) {
            int first = codes[i - 1] - '0';
            int second = (codes[i - 2] - '0') * 10 + first;
            // 排除0
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            // 两位数合法
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i ++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
