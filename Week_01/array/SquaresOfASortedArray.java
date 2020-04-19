package array;

/**
 * 思路：
 * 类似归并，先找到最小自然数的位置，
 * 然后用两个指针比较平方值的大小，并往两个边界延伸
 * @author fuwuchen
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        int j = 0, n = A.length;
        while (j < n && A[j] < 0) j ++;
        int i = j - 1, k = 0;
        int[] res = new int[n];
        while (i >= 0 && j < n) {
            if (A[i] * A[i] < A[j] * A[j]) {
                res[k++] = A[i] * A[i];
                i --;
            }
            else {
                res[k++] = A[j] * A[j];
                j ++;
            }
        }
        while (i >= 0) {
            res[k++] = A[i] * A[i];
            i --;
        }
        while (j < n) {
            res[k++] = A[j] * A[j];
            j ++;
        }
        return res;
    }
}
