/*
 * @lc app=leetcode id=208 lang=cpp
 *
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (58.63%)
 * Likes:    7176
 * Dislikes: 92
 * Total Accepted:    597K
 * Total Submissions: 1M
 * Testcase Example:
 '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to
 * efficiently store and retrieve keys in a dataset of strings. There are
 * various applications of this data structure, such as autocomplete and
 * spellchecker.
 *
 * Implement the Trie class:
 *
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie
 * (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously
 * inserted string word that has the prefix prefix, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 *
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 10^4 calls in total will be made to insert, search, and
 * startsWith.
 *
 *
 */

// @lc code=start
class Trie {
public:
  struct TrieNode {
    std::shared_ptr<TrieNode> children[26];
    bool is_end = false;
    TrieNode() { is_end = false; }
  };
  Trie() { root = make_shared<TrieNode>(); }

  void insert(string word) {
    auto node = root;
    for (char c : word) {
      if (node->children[c - 'a'] == nullptr) {
        node->children[c - 'a'] = make_shared<TrieNode>();
      }
      node = node->children[c - 'a'];
    }
    node->is_end = true;
  }

  bool search(string word) {
    bool found = false;
    auto node = root;
    for (int i = 0; i < word.length(); i++) {
      if (node->children[word[i] - 'a'] != nullptr) {
        node = node->children[word[i] - 'a'];
      } else {
        return false;
      }
    }
    return node != nullptr && node->is_end;
  }

  bool startsWith(string prefix) {
    bool found = false;
    auto node = root;
    for (int i = 0; i < prefix.length(); i++) {
      if (node->children[prefix[i] - 'a'] != nullptr) {
        node = node->children[prefix[i] - 'a'];
      } else {
        return false;
      }
    }
    return node != nullptr;
  }

private:
  std::shared_ptr<TrieNode> root = nullptr;
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
// @lc code=end
