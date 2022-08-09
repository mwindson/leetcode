/*
 * @lc app=leetcode id=140 lang=cpp
 *
 * [140] Word Break II
 *
 * https://leetcode.com/problems/word-break-ii/description/
 *
 * algorithms
 * Hard (42.50%)
 * Likes:    5170
 * Dislikes: 484
 * Total Accepted:    464.8K
 * Total Submissions: 1.1M
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 * Given a string s and a dictionary of strings wordDict, add spaces in s to
 * construct a sentence where each word is a valid dictionary word. Return all
 * such possible sentences in any order.
 *
 * Note that the same word in the dictionary may be reused multiple times in
 * the segmentation.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 *
 *
 * Example 2:
 *
 *
 * Input: s = "pineapplepenapple", wordDict =
 * ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 *
 *
 * Example 3:
 *
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 *
 *
 */

// @lc code=start
class Solution {
public:
  struct TrieNode {
    std::shared_ptr<TrieNode> children[26];
    bool is_end = false;
    TrieNode() { is_end = false; }
  };
  struct Trie {
    shared_ptr<TrieNode> root = nullptr;
    Trie() { root = make_shared<TrieNode>(); }

    void AddWord(const string &word) {
      auto node = root;
      for (char c : word) {
        if (node->children[c - 'a'] == nullptr) {
          node->children[c - 'a'] = make_shared<TrieNode>();
        }
        node = node->children[c - 'a'];
      }
      node->is_end = true;
    }
    vector<string> findPrefixWords(const string &sentence) {
      auto node = root;
      vector<string> words;
      string prefix;
      for (char c : sentence) {
        if (node->children[c - 'a'] != nullptr) {
          node = node->children[c - 'a'];
          prefix += c;
          if (node->is_end) {
            words.emplace_back(prefix);
          }
        } else {
          break;
        }
      }
      return words;
    }
  };
  vector<string> wordBreak(string s, vector<string> &wordDict) {
    for (const auto &word : wordDict) {
      trie.AddWord(word);
    }
    vector<string> sentences;
    vector<string> words;
    find(s, sentences, words);
    return sentences;
  }
  void find(const string &s, vector<string> &sentences, vector<string> &words) {
    if (s.empty()) {
      string sentence;
      for (int i = 0; i < words.size(); i++) {
        if (i != 0) {
          sentence += " ";
        }
        sentence += words[i];
      }
      sentences.emplace_back(sentence);
      return;
    }
    vector<string> possible_words = trie.findPrefixWords(s);
    for (const auto &w : possible_words) {
      words.emplace_back(w);
      find(s.substr(w.length()), sentences, words);
      words.pop_back();
    }
  }

private:
  Trie trie;
};
// @lc code=end
