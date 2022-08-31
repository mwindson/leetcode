/*
 * @lc app=leetcode id=648 lang=cpp
 *
 * [648] Replace Words
 *
 * https://leetcode.com/problems/replace-words/description/
 *
 * algorithms
 * Medium (62.13%)
 * Likes:    1694
 * Dislikes: 156
 * Total Accepted:    105.4K
 * Total Submissions: 168.5K
 * Testcase Example:  '["cat","bat","rat"]\n"the cattle was rattled by the
 * battery"'
 *
 * In English, we have a concept called root, which can be followed by some
 * other word to form another longer word - let's call this word successor. For
 * example, when the root "an" is followed by the successor word "other", we
 * can form a new word "another".
 *
 * Given a dictionary consisting of many roots and a sentence consisting of
 * words separated by spaces, replace all the successors in the sentence with
 * the root forming it. If a successor can be replaced by more than one root,
 * replace it with the root that has the shortest length.
 *
 * Return the sentence after the replacement.
 *
 *
 * Example 1:
 *
 *
 * Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled
 * by the battery"
 * Output: "the cat was rat by the bat"
 *
 *
 * Example 2:
 *
 *
 * Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * Output: "a a b c"
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] consists of only lower-case letters.
 * 1 <= sentence.length <= 10^6
 * sentence consists of only lower-case letters and spaces.
 * The number of words in sentence is in the range [1, 1000]
 * The length of each word in sentence is in the range [1, 1000]
 * Every two consecutive words in sentence will be separated by exactly one
 * space.
 * sentence does not have leading or trailing spaces.
 *
 *
 */

// @lc code=start
class Solution {
public:
  struct TrieNode {
    bool is_end = false;
    vector<TrieNode *> children{26, nullptr};
  };
  class Trie {
  public:
    Trie() { root = new TrieNode(); };

    void AddWord(const string &word) {
      auto node = root;
      for (int i = 0; i < word.length(); i++) {
        if (node->children[word[i] - 'a'] == nullptr) {
          node->children[word[i] - 'a'] = new TrieNode;
        }
        node = node->children[word[i] - 'a'];
      }
      node->is_end = true;
    }

    string SearchPrefix(const string &word) {
      auto node = root;
      string prefix;
      for (int i = 0; i < word.length(); i++) {
        char c = word[i];
        prefix += c;
        auto child = node->children[c - 'a'];
        if (child == nullptr) {
          return "";
        }
        if (child->is_end) {
          return prefix;
        }
        node = child;
      }
      return node->is_end ? prefix : "";
    }

  private:
    TrieNode *root = nullptr;
  };
  string replaceWords(vector<string> &dictionary, string sentence) {
    Trie trie;
    for (const auto &word : dictionary) {
      trie.AddWord(word);
    }
    string res;
    int start = -1;
    for (int i = 0; i < sentence.length(); i++) {
      if (sentence[i] == ' ') {
        if (start >= 0) {
          string word = sentence.substr(start, i - start);
          string prefix = trie.SearchPrefix(word);
          res += prefix.empty() ? word : prefix;
          start = -1;
        }
        res += sentence[i];
      } else {
        if (start == -1) {
          start = i;
        }
      }
    }
    if (start > 0) {
      string word = sentence.substr(start);
      string prefix = trie.SearchPrefix(word);
      res += prefix.empty() ? word : prefix;
    }
    return res;
  }
};
// @lc code=end
