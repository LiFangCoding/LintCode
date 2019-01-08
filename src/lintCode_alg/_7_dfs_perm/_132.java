package lintCode_alg._7_dfs_perm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description
 * Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position. One character only be used once in one word. No same word in dictionary
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Given matrix:
 * <p>
 * doaf
 * agai
 * dcan
 * and dictionary:
 * <p>
 * {"dog", "dad", "dgdg", "can", "again"}
 * <p>
 * return {"dog", "dad", "can", "again"}
 * <p>
 * <p>
 * dog:
 * doaf
 * agai
 * dcan
 * dad:
 * <p>
 * doaf
 * agai
 * dcan
 * can:
 * <p>
 * doaf
 * agai
 * dcan
 * again:
 * <p>
 * doaf
 * agai
 * dcan
 * Challenge
 * Using trie to implement your algorithm.
 */
//TODO: reformat own way
public class _132 {
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};

    public List<String> wordSearchII(char[][] board, List<String> words) {
        List<String> results = new ArrayList<String>();

        TrieTree tree = new TrieTree(new TrieNode());
        for (String word : words) {
            tree.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                search(board, i, j, tree.root, results);
            }
        }

        return results;
    }

    public void search(char[][] board,
                       int x,
                       int y,
                       TrieNode root,
                       List<String> results) {
        if (!root.children.containsKey(board[x][y])) {
            return;
        }

        TrieNode child = root.children.get(board[x][y]);

        if (child.word != null) {
            if (!results.contains(child.word)) {
                results.add(child.word);
            }
        }

        char tmp = board[x][y];
        // mark board[x][y] as used
        board[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            if (!isValid(board, x + dx[i], y + dy[i])) {
                continue;
            }
            search(board, x + dx[i], y + dy[i], child, results);
        }
        // revert the mark
        board[x][y] = tmp;
    }

    private boolean isValid(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }

        return board[x][y] != 0;
    }

    class TrieNode {
        String word;
        HashMap<Character, TrieNode> children;

        public TrieNode() {
            word = null;
            children = new HashMap<Character, TrieNode>();
        }
    }

    class TrieTree {
        TrieNode root;

        public TrieTree(TrieNode TrieNode) {
            root = TrieNode;
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!node.children.containsKey(word.charAt(i))) {
                    node.children.put(word.charAt(i), new TrieNode());
                }
                node = node.children.get(word.charAt(i));
            }
            node.word = word;
        }
    }
}

