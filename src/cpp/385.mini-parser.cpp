/*
 * @lc app=leetcode id=385 lang=cpp
 *
 * [385] Mini Parser
 *
 * https://leetcode.com/problems/mini-parser/description/
 *
 * algorithms
 * Medium (36.00%)
 * Likes:    392
 * Dislikes: 1194
 * Total Accepted:    49.7K
 * Total Submissions: 136.9K
 * Testcase Example:  '"324"'
 *
 * Given a string s represents the serialization of a nested list, implement a
 * parser to deserialize it and return the deserialized NestedInteger.
 *
 * Each element is either an integer or a list whose elements may also be
 * integers or other lists.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "324"
 * Output: 324
 * Explanation: You should return a NestedInteger object which contains a
 * single integer 324.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "[123,[456,[789]]]"
 * Output: [123,[456,[789]]]
 * Explanation: Return a NestedInteger object containing a nested list with 2
 * elements:
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 * ⁠   i.  An integer containing value 456.
 * ⁠   ii. A nested list with one element:
 * ⁠        a. An integer containing value 789
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 5 * 10^4
 * s consists of digits, square brackets "[]", negative sign '-', and commas
 * ','.
 * s is the serialization of valid NestedInteger.
 * All the values in the input are in the range [-10^6, 10^6].
 *
 *
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *   public:
 *     // Constructor initializes an empty nested list.
 *     NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     NestedInteger(int value);
 *
 *     // Return true if this NestedInteger holds a single integer, rather than
 * a nested list. bool isInteger() const;
 *
 *     // Return the single integer that this NestedInteger holds, if it holds a
 * single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     int getInteger() const;
 *
 *     // Set this NestedInteger to hold a single integer.
 *     void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer
 * to it. void add(const NestedInteger &ni);
 *
 *     // Return the nested list that this NestedInteger holds, if it holds a
 * nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     const vector<NestedInteger> &getList() const;
 * };
 */
class Solution {
public:
  NestedInteger deserialize(string s) {
    int pos = 0;
    return parse(s, pos);
  }
  NestedInteger parse(const string &s, int &pos) {
    if (s[pos] == '[') {
      return parseList(s, pos);
    }
    return parseNum(s, pos);
  }
  NestedInteger parseNum(const string &s, int &pos) {
    int sign = 1;
    if (s[pos] == '-') {
      sign = -1;
      pos++;
    }
    int num = 0;
    while (pos < s.length() && s[pos] >= '0' && s[pos] <= '9') {
      num = num * 10 + (s[pos] - '0');
      pos++;
    }
    num = num * sign;
    return NestedInteger(num);
  }
  NestedInteger parseList(const string &s, int &pos) {
    pos++;
    NestedInteger n;
    while (pos < s.length() && s[pos] != ']') {
      if (s[pos] == '[') {
        NestedInteger ni = parseList(s, pos);
        n.add(ni);
      } else if (isNumber(s[pos])) {
        NestedInteger ni = parseNum(s, pos);
        n.add(ni);
      } else {
        pos++;
      }
    }
    pos++;
    return n;
  }
  bool isNumber(char c) { return (c >= '0' && c <= '9') || (c == '-'); }
};
// @lc code=end
