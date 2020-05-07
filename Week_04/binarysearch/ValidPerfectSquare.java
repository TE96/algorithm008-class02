package binarysearch;

public class ValidPerfectSquare {

    public boolean isPerfectSquareBinarySearch(int num) {
        long left = 1, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            }
            else if (mid * mid > num) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquareNewton(int num) {
        long a = num;
        while (a * a > num) {
            a = (a + num / a) / 2;
        }
        return a * a == num;
    }
}
