package completed;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

public class UniquePathsWithObstacles {
    public static void main(String[] args) {

        Assert.assertEquals(2, uniquePathsWithObstacles2(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));

        Assert.assertEquals(2, uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
        Assert.assertEquals(3, uniquePathsWithObstacles(new int[][]{
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 0}
        }));
        Assert.assertEquals(0,uniquePathsWithObstacles(new int[][]{
                {1,0,0},
                {0,1,0},
                {0,0,0}
        }));
        Assert.assertEquals(1,uniquePathsWithObstacles(new int[][]{
                {0,1,0},
                {0,0,0},
                {0,1,0}
        }));
        Assert.assertEquals(2,uniquePathsWithObstacles(new int[][]{
                {0,1,0},
                {0,0,1},
                {0,0,0}
        }));
        Assert.assertEquals(0,uniquePathsWithObstacles(new int[][]{{1}}));
        Assert.assertEquals(0,uniquePathsWithObstacles(new int[][]{{0},{1},{0},{1}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1 ) return 0;
        int t = 1;
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1){
              t = 0;
            }
            obstacleGrid[0][i] = t;
        }
        t = 1;
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
               t = 0;
            }
            obstacleGrid[i][0] = t;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
                for (int j = 1; j < obstacleGrid[i].length; j++) {
                    if(obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0;
                        continue;
                    }
                    int top = obstacleGrid[i - 1][j];
                    int left = obstacleGrid[i][j - 1];
                    obstacleGrid[i][j] = top + left;
                }
        }
        int r = obstacleGrid[obstacleGrid.length-1][obstacleGrid[obstacleGrid.length-1].length-1];
        return r == -1 ? 0 : r;
    }


    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }
}