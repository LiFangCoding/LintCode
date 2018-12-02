package LintCode_Algo.BFS_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Have you met this question in a real interview?
 * Example
 * Given n = 2, prerequisites = [[1,0]]
 * Return true
 *
 * Given n = 2, prerequisites = [[1,0],[0,1]]
 * Return false
 */
public class _615 {
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
