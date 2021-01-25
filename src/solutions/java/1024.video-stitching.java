import java.util.Arrays;

/*
 * @lc app=leetcode id=1024 lang=java
 *
 * [1024] Video Stitching
 */

// @lc code=start
class Solution {
    /* 
     * 1.将每一个区间按照左端点递增顺序排列，如果左端点相同，按右端点递增顺序排列；
     * 2.设置两个变量last和far。last表示当前已经覆盖到的区域的最右边距离，far表示在剩下的线段中找到的所有左端点小于等于当前已经覆盖到的区域的右端点的线段中，不断更新最右边的距离；
     * 3.重复以上过程 直到区间全部覆盖 否则区间不能全部覆盖。
     * 4.贪心证明：要求用最少的线段进行覆盖，那么选取的线段必然要尽量长，而已覆盖到的区域之前的地方已经不用考虑了，可以理解成所有可覆盖的左端点都已 
    */
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(clips));
        int res = 0;
        for (int st = 0, end = 0; st < T; st = end, ++res) {
            for (int i = 0; i < clips.length && clips[i][0] <= st; ++i)
                end = Math.max(end, clips[i][1]);
            if (st == end)
                return -1;
        }
        return res;
    }
}
// @lc code=end
