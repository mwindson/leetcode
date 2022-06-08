/*
 * @lc app=leetcode id=383 lang=cpp
 *
 * [383] Ransom Note
 *
 * https://leetcode.com/problems/ransom-note/description/
 *
 * algorithms
 * Easy (55.96%)
 * Likes:    1810
 * Dislikes: 320
 * Total Accepted:    400.3K
 * Total Submissions: 715.3K
 * Testcase Example:  '"a"\n"b"'
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise.
 * 
 * Each letter in magazine can only be used once in ransomNote.
 * 
 * 
 * Example 1:
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote and magazine consist of lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        std::unordered_map<char,int> map = {};
        for(int i = 0;i<magazine.length();i++){
            if(map.count(magazine[i])>0){
                map[magazine[i]]++;
            }else{
                map[magazine[i]]=1;
            }
        }
        for(int i=0;i<ransomNote.length();i++){
            if(map.count(ransomNote[i])==0||map[ransomNote[i]]<=0){
                return false;
            }else{
                map[ransomNote[i]]--;
            }
        }
        return true;
    }
};
// @lc code=end

