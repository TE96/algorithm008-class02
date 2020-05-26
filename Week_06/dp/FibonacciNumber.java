package dp;

public class FibonacciNumber {
    int[] memo = new int[31];
    public int fib(int N) {
        if (N <= 1) {
            memo[N] = N;
            return N;
        }
        if (memo[N] == 0) {
            memo[N] = fib(N - 1) + fib(N - 2);
        }
        return memo[N];
    }
    public int fibBottomUp(int N) {
        memo[0] = 0; memo[1] = 1;
        for (int i = 2; i <= N; i ++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[N];
    }
}