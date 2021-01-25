package javacode;
/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') {
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }
        if (start > end) {
            return sb.toString();
        }
        boolean hasEnd = true;
        int j = end;
        for (int i = end; i >= start; i--) {
            if (s.charAt(i) == ' ') {
                if (hasEnd) {
                    sb.append(s.substring(i + 1, j + 1));
                    sb.append(" ");
                    hasEnd = false;
                }
            } else {
                if (!hasEnd) {
                    hasEnd = true;
                    j = i;
                }
            }
        }
        if(hasEnd){
            sb.append(s.substring(start, j + 1));
        }
        if (sb.charAt(sb.length() - 1) == ' ') {
            return sb.substring(0, sb.length() - 1);
        }
        return sb.toString();
    }
}
// @lc code=end
