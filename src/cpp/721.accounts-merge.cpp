/*
 * @lc app=leetcode id=721 lang=cpp
 *
 * [721] Accounts Merge
 *
 * https://leetcode.com/problems/accounts-merge/description/
 *
 * algorithms
 * Medium (56.00%)
 * Likes:    4471
 * Dislikes: 801
 * Total Accepted:    261.3K
 * Total Submissions: 465.7K
 * Testcase Example:
 * '[["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]'
 *
 * Given a list of accounts where each element accounts[i] is a list of
 * strings, where the first element accounts[i][0] is a name, and the rest of
 * the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts. Two accounts definitely belong
 * to the same person if there is some common email to both accounts. Note that
 * even if two accounts have the same name, they may belong to different people
 * as people could have the same name. A person can have any number of accounts
 * initially, but all of their accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the
 * first element of each account is the name, and the rest of the elements are
 * emails in sorted order. The accounts themselves can be returned in any
 * order.
 *
 *
 * Example 1:
 *
 *
 * Input: accounts =
 * [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * Output:
 * [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * Explanation:
 * The first and second John's are the same person as they have the common
 * email "johnsmith@mail.com".
 * The third John and Mary are different people as none of their email
 * addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary',
 * 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']]
 * would still be accepted.
 *
 *
 * Example 2:
 *
 *
 * Input: accounts =
 * [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
 * Output:
 * [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= accounts.length <= 1000
 * 2 <= accounts[i].length <= 10
 * 1 <= accounts[i][j].length <= 30
 * accounts[i][0] consists of English letters.
 * accounts[i][j] (for j > 0) is a valid email.
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<vector<string>> accountsMerge(vector<vector<string>> &accounts) {
    unordered_map<string, int> user;
    vector<int> union_find(accounts.size(), 0);
    for (int i = 0; i < accounts.size(); i++) {
      if (accounts[i].size() == 0) {
        continue;
      }
      union_find[i] = i;
      for (int j = 1; j < accounts[i].size(); i++) {
        string mail = accounts[i][j];
        if (user.count(mail) > 0) {
          int root1 = find(union_find, i);
          int root2 = find(union_find, user[mail]);
          union_find[root1] = root2;
        } else {
          user[mail] = union_find[i];
        }
      }
    }
    unordered_map<int, vector<string>> res_map;
    for (auto it : user) {
      int index = find(union_find, it.second);
      res_map[index].push_back(it.first);
    }
    vector<vector<string>> res;
    for (auto it : res_map) {
      vector<string> email = it.second;
      sort(email.begin(), email.end());
      email.insert(email.begin(), accounts[it.first][0]);
      res.emplace_back(email);
    }
    return res;
  }
  int find(vector<int> &union_find, int index) {
    if (union_find[index] == index) {
      return index;
    }
    union_find[index] = find(union_find, union_find[index]);
    return union_find[index];
  }
};
// @lc code=end
