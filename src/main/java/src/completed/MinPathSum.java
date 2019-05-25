package completed;

import org.junit.Assert;

public class MinPathSum {
    public static void main(String[] args) {
        Assert.assertEquals(7,minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
        Assert.assertEquals(9,minPathSum(new int[][]{
                {1,3,1},
                {1,5,8},
                {4,2,1}
        }));
    }
    public static int minPathSum(int[][] grid) {
        int len = grid[0].length;
        int[] dep = grid[0];
        for(int i=1;i<len;i++) dep[i] += dep[i-1];
        for(int j = 1;j<grid.length;j++){
            int[] g = grid[j];
            for(int i=0;i<g.length;i++){
                if(i>0){
                    int t = dep[i-1] < dep[i] ? dep[i-1] : dep[i];
                    dep[i] = t + g[i];
                }else {
                    dep[i] += g[i];
                }
            }
        }
        return dep[len-1];
    }
}