package Problem201_300;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mwindson on 2017/6/27.
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/#/description
 */
public class Problem211 {
    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("a");
        obj.addWord("ab");
        System.out.println(obj.search("a"));
        System.out.println(obj.search("a."));
        System.out.println(obj.search("ab"));
        System.out.println(obj.search(".a"));
        System.out.println(obj.search(".b"));
        System.out.println(obj.search("ab."));
        System.out.println(obj.search("."));
        System.out.println(obj.search(".."));
        System.out.println(obj.search("..."));
    }

    public static class WordDictionary {
        private int size = 26;
        private TrieNode root;

        private class TrieNode {
            TrieNode[] children;// 孩子
            char val; // 字节值
            boolean isEnd;// 是否结束

            TrieNode() {
                children = new TrieNode[size];
            }

            TrieNode(char c) {
                children = new TrieNode[size];
                val = c;
            }
        }

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new TrieNode();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new TrieNode(c);
                curr.children[c - 'a'].isEnd = curr.children[c - 'a'].isEnd | i == word.length() - 1;
                curr = curr.children[c - 'a'];
            }
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            List<String> list = new ArrayList<>();
            backTracking(list, word, "", -1, root);
            return !list.isEmpty();
        }

        private void backTracking(List<String> list, String word, String curr, int index, TrieNode node) {
            if (index == word.length() - 1) {
                if (node.isEnd)
                    list.add(curr);
            } else {
                char c = word.charAt(index + 1);
                if (c == '.') {
                    for (TrieNode t : node.children) {
                        if (t != null)
                            backTracking(list, word, curr + c, index + 1, t);
                    }
                } else if (node.children[c - 'a'] != null) {
                    backTracking(list, word, curr + c, index + 1, node.children[c - 'a']);
                }
            }
        }
    }
}
