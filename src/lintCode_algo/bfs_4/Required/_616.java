package lintCode_algo.bfs_4.Required;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 *
 * Have you met this question in a real interview?
 * Example
 * Given n = 2, prerequisites = [[1,0]]
 * Return [0,1]
 *
 * Given n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
 * Return [0,1,2,3] or [0,2,1,3]
 */
public class _616 {
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
        int[] res = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()) {
            int cur = q.remove();
            res[count] = cur;
            count++;

            List<Integer> nbrs = graph[cur];
            for (int nbr : nbrs) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    q.offer(nbr);
                }
            }
        }

        if (count == numCourses) {
            return res;
        }

        return new int[0];
    }
}
