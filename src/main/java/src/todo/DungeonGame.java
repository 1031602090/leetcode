package todo;

public class DungeonGame {
    public static void main(String[] args) {

    }

    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0)
            return 0;
        int curHealth = 1;
        int dp[][] = new int[dungeon.length][dungeon[0].length];
        dp[0][0] = dungeon[0][0] > 0 ? 0 : Math.abs(dungeon[0][0]) + 1;
        for (int i = 0; i < dungeon.length; i++) {
            for (int j = 0; j < dungeon[i].length; j++) {
                if (dungeon[i][j] >= 0) {
                    curHealth += dungeon[i][j];
                } else if (dungeon[i][j] + curHealth < 0) {
                    curHealth = 1;
                    
                }
            }
        }
        int ans = dungeon[dungeon.length - 1][dungeon[0].length - 1];
        return ans > 0 ? 0 : -ans;
    }

}
