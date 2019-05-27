package completed;

import org.junit.Assert;

import java.util.Arrays;

public class SearchMatrix {
    public static void main(String[] args) {
        Assert.assertTrue(searchMatrix(new int[][]{
                {1}, {2}
        }, 2));
        Assert.assertTrue(searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 3));
        Assert.assertTrue(searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 11));

        Assert.assertTrue(!searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 13));

        Assert.assertTrue(!searchMatrix(new int[][]{
                {1, 3, 5, 7}
        }, 2));
        Assert.assertTrue(!searchMatrix(new int[][]{
                {1}
        }, 2));
        Assert.assertTrue(searchMatrix(new int[][]{
                {1}, {2}, {3}, {5}, {7}, {20}
        }, 2));

        Assert.assertTrue(!searchMatrix(new int[][]{
                {1}, {2}
        }, 0));
        Assert.assertTrue(!searchMatrix(new int[][]{
                {1}, {2}
        }, 3));
        Assert.assertTrue(searchMatrix(new int[][]{
                {1}, {2}
        }, 2));

        Assert.assertTrue(searchMatrix(new int[][]{
                {1}
        }, 1));

        Assert.assertTrue(!searchMatrix(new int[][]{}, 2));

        Assert.assertTrue(!searchMatrix(new int[][]{{}}, 2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length ==0 || matrix[0].length == 0) return false;
        if(target < matrix[0][0] || target > matrix[matrix.length-1][matrix[matrix.length-1].length-1]) return false;
        int left = 0;
        int right = matrix.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) >>> 1;
            int t = matrix[mid][0];
            if (target < t)
                right = mid - 1;
            else if (t == target)
                return true;
            else
                left = mid + 1;
        }
        return Arrays.binarySearch(matrix[left - 1], target) >= 0;
    }

}