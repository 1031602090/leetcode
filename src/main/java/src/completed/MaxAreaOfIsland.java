package completed;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int i = new MaxAreaOfIsland().maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}
        );
        System.out.println(i);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = new boolean[grid[i].length];
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(i, j, grid, visited));
                }
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int[][] grid, boolean[][] visited) {
        System.out.println(i + ":" + j);
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }
        visited[i][j] = true;
        return dfs(i + 1, j, grid, visited)
                + dfs(i - 1, j, grid, visited)
                + dfs(i, j + 1, grid, visited)
                + dfs(i, j - 1, grid, visited)
                + 1;
    }
}
