package Problem501_600;

/**
 * Created by mwindson on 2017/8/4.
 * https://leetcode.com/problems/super-washing-machines/discuss/
 */
public class Problem517 {
    public static void main(String[] args) {
        int[] machines = {0, 0, 11, 5};
        System.out.println(findMinMoves(machines));
    }

    public static int findMinMoves(int[] machines) {
        int total = 0, max = 0;
        for (int machine : machines) total += machine;
        if (total % machines.length != 0) return -1;
        int avg = total / machines.length;
        int cnt = 0;
        for (int machine : machines) {
            cnt += machine - avg;
            max = Math.max(Math.max(max, Math.abs(cnt)), machine - avg);
        }
        return max;
    }
}
