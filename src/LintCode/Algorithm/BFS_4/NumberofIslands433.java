package LintCode.Algorithm.BFS_4;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands433 {
    class P {
        int x;
        int y;
        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;
        boolean[][] v = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] && !v[i][j]) {
                    ans++;
                    bfs(grid, v, i, j);
                }
            }
        }
        return ans;
    }

    private void bfs(boolean[][] grid, boolean[][] v, int sx, int sy) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<P> q = new LinkedList<>();
        q.offer(new P(sx, sy));
        v[sx][sy] = true;

        while (!q.isEmpty()) {
            P p = q.poll();
            // find all neighbors
            for (int i = 0; i < dx.length; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                // if is valid and is 1.
                if (isValid(grid, nx, ny)) {
                    if (!v[nx][ny]) {
                        v[nx][ny] = true;
                        q.offer(new P(nx, ny));
                    }
                }
            }
        }
    }

    private boolean isValid(boolean[][] grid, int nx, int ny) {
        return nx >= 0 && nx < grid.length && ny >=0 && ny < grid[0].length && grid[nx][ny];
    }
}
