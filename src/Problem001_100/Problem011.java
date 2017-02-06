package Problem001_100;

/**
 * Created by mwindson on 2017/2/6.
 * https://leetcode.com/problems/container-with-most-water/
 */
public class Problem011 {
    public static void main(String[] args) {
        int[] height = {1, 3, 2, 5, 25, 24, 5};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            //左右边较小边变化，找到下一个可能的边
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}
