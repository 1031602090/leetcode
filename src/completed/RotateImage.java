package completed;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/rotate-image/"></a>
 */
public class RotateImage {
    public static void rotate(int[][] matrix) {
        reverse(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix.length;j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }

    private static void reverse(int[][] matrix) {
        int[] t;
        for(int i=0;i<matrix.length/2;i++){
            t = matrix[i];
            matrix[i] = matrix[matrix.length-i-1];
            matrix[matrix.length-i-1] = t;
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(a);
        System.out.println(Arrays.deepToString(a));

    }

}