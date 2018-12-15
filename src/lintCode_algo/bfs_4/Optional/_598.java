package lintCode_algo.bfs_4.Optional;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D grid, each cell is either a wall 2, a zombie 1 or people 0 (the number zero, one,
 * two).Zombies can turn the nearest people(up/down/left/right) into zombies every day, but can not
 * through wall. How long will it take to turn all people into zombies? Return -1 if can not turn
 * all people into zombies.
 *
 * <p>Have you met this question in a real interview? Example Given a matrix:
 *
 * <p>0 1 2 0 0 1 0 0 2 1 0 1 0 0 0 return 2
 */
public class _598 {
    public int zombie(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        return bfs(grid);
    }

    private int bfs(int[][] grid) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Coor> q = new LinkedList<>();
        int peoples = 0;
        int m = grid.length;
        int n = grid[0].length;
        // The default value for a Boolean (object) is null.
        // The default value for a boolean (primitive) is false.
        boolean[][] marked = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Coor(i, j));
                    marked[i][j] = true;
                } else if (grid[i][j] == 0) {
                    peoples++;
                }
            }
        }

        // If change the status into zombies, no need to track it. Since it is not people, q will not
        // add the previous one.
        // But if not change, we need to track of our previous setting.
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            // for one level.
            for (int i = 0; i < size; i++) {
                Coor cur = q.remove();
                if (grid[cur.x][cur.y] == 0) {
                    peoples--;
                    if (peoples == 0) {
                        return step;
                    }
                }
                // cannot name same i here
                for (int dir = 0; dir < dx.length; dir++) {
                    int newx = cur.x + dx[dir];
                    int newy = cur.y + dy[dir];
                    if (inBound(newx, newy, grid) && grid[newx][newy] == 0 && !marked[newx][newy]) {
                        q.add(new Coor(newx, newy));
                        marked[newx][newy] = true;
                        if (peoples == 1) {
                            return step + 1;
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private boolean inBound(int x, int y, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    class Coor {
        int x;
        int y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
