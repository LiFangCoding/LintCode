package LintCode.Algorithm.BFS_4;

import common.Point;

import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestPath {
    public int shortestPath(boolean[][] grid, Point s, Point d) {
        // write your code here
        if (grid == null || grid[s.x][s.y] || grid[d.x][d.y]) {
            return -1;
        }

        if (!inbound(grid, s.x, s.y) || !inbound(grid, d.x, d.y)) {
            return -1;
        }

        return bfs(grid, s, d);
    }

    // bfs shortestPath
    private int bfs(boolean[][] grid, Point s, Point d) {
        Queue<Point> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] v = new boolean[m][n];

        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy= {2, -2, 2, -2, 1, -1, 1, -1};

        q.add(s);
        v[s.x][s.y] = true;

        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point cur = q.remove();
                if (cur.x == d.x && cur.y == d.y) {
                    return dist;
                }
                for (int j = 0; j < dx.length; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (inbound(grid, nx, ny) && !v[nx][ny] && !grid[nx][ny]) {
                        q.add(new Point(nx, ny));
                        v[nx][ny] = true;
                    }
                }
            }
            dist++;
        }
        return -1;
    }

    private boolean inbound(boolean[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        return x >= 0 && x < m && y >=0 && y < n;
    }
}
