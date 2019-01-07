package completed;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/spiral-matrix/"></a>
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int col = matrix[0].length - 1, c = 0;
        int row = matrix.length - 1, r = 0;
        while (c <= col && r <= row) {
            for (int c1 = c; c1 <= col; c1++) res.add(matrix[r][c1]);
            for (int r1 = r+1; r1 <= row; r1++) res.add(matrix[r1][col]);
            if (r < row && c < col) {
                for (int c1 = col-1; c1 > c  ; c1--) res.add(matrix[row][c1]);
                for (int r1 = row; r1 > r; r1--) res.add(matrix[r1][c]);
            }
            col--;
            row--;
            r++;
            c++;
        }
        //  res.add(matrix[r-1][c-1]);
        System.out.println(res);
        return res;
    }


    public static void main(String[] args) {
        int[][] t = new int[][]{
                {1},
                {5},
                {9}
        };
        int[][] t1 = new int[][]{
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11}
        };
        int[][] t2 = new int[][]{{1, 2, 3, 4, 5, 6}};
        int[][] t3 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int[][] t4 = new int[][]{
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11},
                {12, 13, 14}
        };
        int[][] t5 = new int[][]{
                {1, 2},
                {5, 6}
        };
        System.out.println(spiralOrder(t).size() == 3);
        System.out.println(spiralOrder(t1).size() == 9);
        System.out.println(spiralOrder(t2).size() == 6);
        System.out.println(spiralOrder(t3).size() == 12);
        System.out.println(spiralOrder(t4).size() == 12);
        System.out.println(spiralOrder(t5).size() == 4);

    }
}
