package Problem001_100;

/**
 * Created by mwindson on 2017/2/17.
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class Problem042 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        if (height.length == 0)
            return 0;
        int waterArea = 0;
        int allArea = 0;
        int mapArea = 0;
        int currentHeight = 0;
        int currentIndex = 0;
        int maxHeight = 0;
        int maxFirstIndex = 0;
        int maxLastIndex = 0;
        // 确定最大高度的两个边界值
        for (int i = 0; i < height.length; i++) {
            mapArea += height[i];
            if (maxHeight < height[i]) {
                maxHeight = height[i];
                maxFirstIndex = i;
                maxLastIndex = i;
            } else if (maxHeight == height[i]) {
                maxLastIndex = i;
            }
        }
        //计算waterArea + mapArea
        for (int i = 0; i <= maxFirstIndex; i++) {
            if (currentHeight < height[i]) {
                allArea += currentHeight * (i - currentIndex);
                currentIndex = i;
                currentHeight = height[i];
            }
        }
        allArea += maxHeight * (maxLastIndex - maxFirstIndex + 1);
        currentHeight = 0;
        currentIndex = height.length - 1;
        for (int i = height.length - 1; i >= maxLastIndex; i--) {
            if (currentHeight < height[i]) {
                allArea += currentHeight * (currentIndex - i);
                currentIndex = i;
                currentHeight = height[i];
            }
        }
        waterArea = allArea - mapArea;
        return waterArea;
    }
}
