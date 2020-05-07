package binarysearch;

public class Sqrtx {
    public int mySqrtBinarySearch(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long left = 1, right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return (int) right;
    }
    public int mySqrtNewton(int x) {
        long a = x;
        while (a * a > x) {
            a = (a + x / a) / 2;
        }
        return (int)a;
    }
}
