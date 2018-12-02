package LintCode_Algo.BFS_4;
import  java.util.*;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * Have you met this question in a real interview?
 * Example
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 */
public class _120 {
    public int ladderLength(String s, String e, Set<String> dict) {
        // write your code here
        if (dict == null) {
            return 0;
        }
        if (s.equals(e)) {
            return 1;
        }

        return bfsSteps(s, e ,dict);
    }

    private int bfsSteps(String s, String e, Set<String> dict) {
        Queue<String> q = new LinkedList<>();
        Set<String> vsted = new HashSet<>();
        int step = 1;

        q.add(s);
        vsted.add(s);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.remove();
                if (cur.equals(e)) {
                    return step;
                }
                List<String> nbrs = getNbrs(cur, dict, e);
                for (String nbr : nbrs) {
                    if (nbr.equals(e)) {
                        return step + 1;
                    }
                    if (!vsted.contains(nbr)) {
                        q.add(nbr);
                        vsted.add(nbr);
                    }
                }
            }
            step++;
        }
        return step;
    }

    private List<String> getNbrs(String s, Set<String> dict, String e) {
        char[] chars = s.toCharArray();
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (chars[i] == c) {
                    continue;
                }
                char origin = chars[i];
                chars[i] = c;
                String nbr = new String(chars);
                if (nbr.equals(e) || dict.contains(nbr)) {
                    ans.add(nbr);
                }
                chars[i] = origin;
            }
        }
        return ans;
    }
}
