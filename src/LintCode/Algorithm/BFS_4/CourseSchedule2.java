package LintCode.Algorithm.BFS_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        List[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        int n = prerequisites.length;
        for (int i = 0; i < n; i++) {
            int[] prereq = prerequisites[i];
            graph[prereq[1]].add(prereq[0]);
            indegree[prereq[0]]++;
        }

        return bfs(graph, indegree, numCourses);
    }

    private int[] bfs(List[] graph, int[] indegree, int numCourses) {
        int[] ans = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()) {
            int cur = q.remove();
            ans[count] = cur;
            count++;

            List<Integer> neibs = graph[cur];
            for (int neib : neibs) {
                indegree[neib]--;
                if (indegree[neib] == 0) {
                    q.offer(neib);
                }
            }
        }

        if (count == numCourses) {
            return ans;
        }

        return new int[0];
    }
}
