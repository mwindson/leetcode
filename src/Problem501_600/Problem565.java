package Problem501_600;

/**
 * Created by mwindson on 2017/6/7.
 * https://leetcode.com/problems/array-nesting/#/description
 */
public class Problem565 {
    public static void main(String[] args) {
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(arrayNesting(nums));
    }

    public static int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int len = fingLoop(nums, visited, i);
                longest = Math.max(len, longest);
            }
        }
        return longest;
    }

    private static int fingLoop(int[] nums, boolean[] visited, int start) {
        int index = start;
        int len = 0;
        while (!visited[index]) {
            len++;
            visited[index] = true;
            index = nums[index];
        }
        return len;
    }
}
