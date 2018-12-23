import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/rotate-image/"></a>
 */
public class RotateImage {
    public static void rotate(int[][] matrix) {


    }


    public static void main(String[] args) {
        /*int[][] a = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };*/
        int[][] a = new int[][]{
                { 5, 1, 9,11},
                { 2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        rotate(a);
        System.out.println(Arrays.deepToString(a));
//        System.out.println(Arrays.toString(getNextPos(1, 2, 2,2,1,1)));

    }
}