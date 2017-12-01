package Problem701_800;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by mwindson on 2017/11/30.
 * https://leetcode.com/problems/longest-word-in-dictionary/description/
 */
public class Problem720 {
    public static void main(String[] args) {
        String[] words = {"w", "wo", "wor", "worl", "world", "a", "a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(longestWord(words));
    }

    static class Trie {
        Trie[] children;
        boolean isEnd = false;
        String val;

        Trie() {
            children = new Trie[26];
        }

        Trie(String c) {
            children = new Trie[26];
            val = c;
        }
    }

    public static String longestWord(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null)
                    node.children[c - 'a'] = new Trie(word.substring(0, i + 1));
                node = node.children[c - 'a'];
                if (i == word.length() - 1) {
                    node.isEnd = true;
                }
            }
        }
        String longestWord = "";
        Queue<Trie> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Trie current = q.poll();
            boolean hasChildren = false;
            for (Trie child : current.children) {
                if (child != null && child.isEnd) {
                    hasChildren = true;
                    q.add(child);
                }
            }
            if (!hasChildren) {
                if (current.val.length() > longestWord.length()) {
                    longestWord = current.val;
                } else if (current.val.length() == longestWord.length()) {
                    if (longestWord.compareTo(current.val) > 0) {
                        longestWord = current.val;
                    }
                }
            }
        }
        return longestWord;
    }
}
