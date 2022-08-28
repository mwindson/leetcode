/*
 * @lc app=leetcode id=318 lang=cpp
 *
 * [318] Maximum Product of Word Lengths
 *
 * https://leetcode.com/problems/maximum-product-of-word-lengths/description/
 *
 * algorithms
 * Medium (60.24%)
 * Likes:    3003
 * Dislikes: 119
 * Total Accepted:    193.1K
 * Total Submissions: 320.7K
 * Testcase Example:  '["abcw","baz","foo","bar","xtfn","abcdef"]'
 *
 * Given a string array words, return the maximum value of length(word[i]) *
 * length(word[j]) where the two words do not share common letters. If no such
 * two words exist, return 0.
 *
 *
 * Example 1:
 *
 *
 * Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 *
 *
 * Example 2:
 *
 *
 * Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 *
 *
 * Example 3:
 *
 *
 * Input: words = ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 *
 *
 *
 * Constraints:
 *
 *
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] consists only of lowercase English letters.
 *
 *
 */

// @lc code=start
class Solution {
public:
  int maxProduct(vector<string> &words) {
    vector<int> word_bits;
    for (auto &word : words) {
      word_bits.emplace_back(getWordBit(word));
    }
    int max_product = 0;
    for (int i = 0; i < word_bits.size(); i++) {
      for (int j = i + 1; j < word_bits.size(); j++) {
        if ((word_bits[i] & word_bits[j]) == 0) {
          max_product =
              max<int>(max_product, words[i].length() * words[j].length());
        }
      }
    }
    return max_product;
  }
  int getWordBit(const string &word) {
    int bit = 0;
    for (char c : word) {
      bit |= 1 << (c - 'a');
    }
    return bit;
  }
};
// @lc code=end
