/*
 * @lc app=leetcode id=93 lang=cpp
 *
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (42.13%)
 * Likes:    2970
 * Dislikes: 635
 * Total Accepted:    314.1K
 * Total Submissions: 734.7K
 * Testcase Example:  '"25525511135"'
 *
 * A valid IP address consists of exactly four integers separated by single
 * dots. Each integer is between 0 and 255 (inclusive) and cannot have leading
 * zeros.
 *
 *
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but
 * "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP
 * addresses.
 *
 *
 * Given a string s containing only digits, return all possible valid IP
 * addresses that can be formed by inserting dots into s. You are not allowed
 * to reorder or remove any digits in s. You may return the valid IP addresses
 * in any order.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 *
 *
 * Example 2:
 *
 *
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 *
 *
 * Example 3:
 *
 *
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 20
 * s consists of digits only.
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<string> restoreIpAddresses(string s) {
    vector<string> addrs;
    restore(s, 0, "", addrs);
    return ips;
  }
  void restore(string s, int index, string prev, vector<string> &addrs) {
    if (index >= s.length()) {
      addrs.emplace_back(prev);
      if (addrs.size() == 4) {
        string ip;
        for (int i = 0; i < addrs.size(); i++) {
          if (i > 0) {
            ip += ".";
          }
          ip += addrs[i];
        }
        ips.emplace_back(ip);
      }
      addrs.pop_back();
      return;
    }
    if (addrs.size() > 4) {
      return;
    }
    if (prev != "") {
      // new ip
      addrs.emplace_back(prev);
      restore(s, index + 1, s.substr(index, 1), addrs);
      addrs.pop_back();
    }
    string next = prev + s[index];
    if (prev != "0" && atoi(next.c_str()) <= 255) {
      // current ip
      restore(s, index + 1, next, addrs);
    }
  }

private:
  vector<string> ips;
};
// @lc code=end
