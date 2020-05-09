package binarysearch;

public class SearchA2DMatrix {

    /**
     * 将二维数组看成一个有序一维数组
     * 进行二分查找
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        int lo = 0, hi = row * col - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[mid / col][mid % col] == target) {
                return true;
            }
            else if (matrix[mid / col][mid % col] > target) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return false;
    }

    public boolean searchMatrixBruteForce(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i ++) {
            if (matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }
    private boolean binarySearch(int[] row, int target) {
        int lo = 0, hi = row.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (row[mid] == target) {
                return true;
            }
            else if (row[mid] > target) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return false;
    }
}
