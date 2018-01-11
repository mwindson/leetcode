package Problem701_800;

/**
 * Created by mwindson on 2018/1/10.
 */
public class Problem746 {
    public static void main(String[] args) {
        int[] cost = {1, 1, 1, 1};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] minCost = new int[len + 1];
        minCost[0] = 0;
        minCost[1] = 0;
        for (int i = 2; i < len + 1; i++) {
            minCost[i] = Math.min(minCost[i - 1] + cost[i - 1], minCost[i - 2] + cost[i - 2]);
        }
        return minCost[len];
    }
}
