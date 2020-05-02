package dc;

public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n < 0) {
            // 处理n = Integer.MIN_VALUE的边界情况
            x = 1 / x;
            return x * myPow(x, -n - 1);
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }
        return x * myPow(x, n - 1);
    }
}
