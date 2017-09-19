package Problem600_700;

import Problem201_300.Problem211;

import java.util.HashSet;

/**
 * Created by mwindson on 2017/9/14.
 * https://leetcode.com/problems/implement-magic-dictionary/description/
 */
public class Problem676 {
    static class MagicDictionary {

        HashSet<String> dictSet;

        /**
         * Initialize your data structure here.
         */
        public MagicDictionary() {
            dictSet = new HashSet<>();
        }

        /**
         * Build a dictionary through a list of words
         */
        public void buildDict(String[] dict) {
            dictSet = new HashSet<String>();
            for (String word : dict)
                dictSet.add(word);
        }

        /**
         * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
         */
        public boolean search(String word) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != ch) {
                        chars[i] = c;
                        if (dictSet.contains(new String(chars)))
                            return true;
                    }
                }
                chars[i] = ch;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        MagicDictionary obj = new MagicDictionary();
        obj.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(obj.search("leatcode"));
        System.out.println(obj.search("hallo"));
    }
}
