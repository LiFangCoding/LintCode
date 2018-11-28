package LintCode.Algorithm.BFS_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        return bfs(graph, indegree) == numCourses;
    }

    // put every indegree == 0  s into queue
    // while, output cur, find the neighbors. decrese neigh indegree.
    // If find indegree == 0, put into queue
    private int bfs(List[] graph, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.remove();
            count++;

            List<Integer> neighbors = graph[cur];
            for (int i : neighbors) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        return count;
    }

}
