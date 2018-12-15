package lintCode_algo.dfs_combination_6;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where
 * each word is a valid dictionary word.
 *
 * <p>Return all such possible sentences.
 *
 * <p>Example Gieve s = lintcode, dict = ["de", "ding", "co", "code", "lint"].
 *
 * <p>A solution is ["lint code", "lint co de"].
 */
public class _582 {
    Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        if (s == null || wordDict == null) {
            return new ArrayList<>();
        }
        return search(s, wordDict);
    }

    // Important: this is not combinational search. So no need to use void. And be care of the
    // duplicate call.
    private List<String> search(String s, Set<String> dict) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        if (len == 0) {
            return res;
        } else if (memo.containsKey(s)) {
            return memo.get(s);
        } else {
            if (dict.contains(s)) {
                res.add(s);
                // cannot return now.
                // Because it needs all solutions.
            }

            for (int i = 1; i <= len - 1; i++) {
                String spre = s.substring(0, i);
                if (dict.contains(spre)) {
                    String ssucc = s.substring(i);
                    List<String> partSols = search(ssucc, dict);
                    for (String partSol : partSols) {
                        res.add(spre + " " + partSol);
                    }
                }
            }
            memo.put(s, res);
            return res;
        }
    }
}
