package lintCode_algo._4_bfs.Required;

import common.Point;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source
 * position, find the shortest path to a destination position, return the length of the route.
 * Return -1 if knight can not reached.
 *
 * <p>source and destination must be empty. Knight can not enter the barrier.
 *
 * <p>Have you met this question in a real interview? Clarification If the knight is at (x, y), he
 * can get to the following positions in one step:
 *
 * <p>(x + 1, y + 2) (x + 1, y - 2) (x - 1, y + 2) (x - 1, y - 2) (x + 2, y + 1) (x + 2, y - 1) (x -
 * 2, y + 1) (x - 2, y - 1) Example [[0,0,0], [0,0,0], [0,0,0]] source = [2, 0] destination = [2, 2]
 * return 2
 *
 * <p>[[0,1,0], [0,0,0], [0,0,0]] source = [2, 0] destination = [2, 2] return 6
 *
 * <p>[[0,1,0], [0,0,1], [0,0,0]] source = [2, 0] destination = [2, 2] return -1
 */
public class _611 {
    public int shortestPath(boolean[][] grid, Point s, Point d) {
        // write your code here
        if (grid == null || grid[s.x][s.y] || grid[d.x][d.y]) {
            return -1;
        }

        if (!inbound(grid, s.x, s.y) || !inbound(grid, d.x, d.y)) {
            return -1;
        }

        return bfsDist(grid, s, d);
    }

    // bfsDist shortestPath
    private int bfsDist(boolean[][] grid, Point s, Point d) {
        Queue<Point> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] makred = new boolean[m][n];

        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};

        q.add(s);
        makred[s.x][s.y] = true;

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
                    if (inbound(grid, nx, ny) && !makred[nx][ny] && !grid[nx][ny]) {
                        q.add(new Point(nx, ny));
                        makred[nx][ny] = true;
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
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
