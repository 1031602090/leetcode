package completed;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {

    public int numIslands(char[][] grid) {
        int c = 0;
        boolean[][] visited = new boolean[grid.length][];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = new boolean[grid[i].length];
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    c++;
                    numIslandsHelper(visited, grid, i, j);
                }
            }
        }
        return c;
    }
    static class Node{
        int k;
        int v;
        Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }
    private void numIslandsHelper(boolean[][] visited, char[][] grid, int i, int j) {
        Queue<Node> entries = new LinkedList<>();
        entries.offer(new Node(i, j));
        while (!entries.isEmpty()) {
            Node entry = entries.poll();
            int x = entry.k;
            int y = entry.v;
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length)
                continue;
            if (visited[x][y] || grid[x][y] == '0') {
                continue;
            }
            visited[x][y] = true;
            entries.offer(new Node(x, y + 1));
            entries.offer(new Node(x, y - 1));
            entries.offer(new Node(x - 1, y));
            entries.offer(new Node(x + 1, y));
        }
    }

/*    private void numIslandsHelper(boolean[][] visited, char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length)
            return;
        if (j < 0 || j >= grid[i].length)
            return;
        if (grid[i][j] == '1' && !visited[i][j])
            visited[i][j] = true;
        else
            return;
        numIslandsHelper(visited, grid, i - 1, j);
        numIslandsHelper(visited, grid, i + 1, j);
        numIslandsHelper(visited, grid, i, j + 1);
        numIslandsHelper(visited, grid, i, j - 1);
    }*/

    public static void main(String[] args) {
        int i = new NumIslands().numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '0', '0', '0', '0'},
                {'0', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '1'}
        });
        System.out.println(i);
    }
}
