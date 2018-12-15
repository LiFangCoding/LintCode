package lintCode_algo.bfs_4.Required;

import java.util.*;

/**
 * 605. Sequence Reconstruction Check whether the original sequence org can be uniquely
 * reconstructed from the sequences in seqs. The org sequence is a permutation of the integers from
 * 1 to n, with 1 ≤ n ≤ 10^4. Reconstruction means building a shortest common supersequence of the
 * sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of
 * it). Determine whether there is only one sequence that can be reconstructed from seqs and it is
 * the org sequence.
 *
 * <p>Example Given org = [1,2,3], seqs = [[1,2],[1,3]] Return false Explanation: [1,2,3] is not the
 * only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be
 * reconstructed.
 *
 * <p>Given org = [1,2,3], seqs = [[1,2]] Return false Explanation: The reconstructed sequence can
 * only be [1,2].
 *
 * <p>Given org = [1,2,3], seqs = [[1,2],[1,3],[2,3]] Return true Explanation: The sequences [1,2],
 * [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
 *
 * <p>Given org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]] Return true
 */

// TODO: Hard
public class _605 {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (int num : org) {
            map.put(num, new HashSet<>());
            indegree.put(num, 0);
        }

        int n = org.length;
        int count = 0;
        for (int[] seq : seqs) {
            count += seq.length;
            // important: when seq larger than 1, and from is not between 0- n.
            if (seq.length >= 1 && (seq[0] <= 0 || seq[0] > n)) {
                return false;
            }
            for (int i = 1; i < seq.length; i++) {
                // exception one.
                if (seq[i] <= 0 || seq[i] > n) {
                    return false;
                }
                if (map.get(seq[i - 1]).add(seq[i])) {
                    indegree.put(seq[i], indegree.get(seq[i]) + 1);
                }
            }
        }

        // case: [1], []
        if (count < n) {
            return false;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                q.add(key);
            }
        }

        int cnt = 0;
        while (q.size() == 1) {
            int cur = q.poll();
            for (int nbr : map.get(cur)) {
                indegree.put(nbr, indegree.get(nbr) - 1);
                if (indegree.get(nbr) == 0) {
                    q.add(nbr);
                }
            }
            if (cur != org[cnt]) {
                return false;
            }
            cnt++;
        }

        return cnt == org.length;
    }
}
