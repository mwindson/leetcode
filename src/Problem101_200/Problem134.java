package Problem101_200;

/**
 * Created by mwindson on 2017/5/18.
 * https://leetcode.com/problems/gas-station/#/description
 */
public class Problem134 {
    public static void main(String[] args) {
        int[] gas = {1, 1, 4};
        int[] cost = {2, 2, 1};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int size = gas.length;
        int sum = 0;
        int res = 0;
        int total = 0;
        for (int i = 0; i < size; ++i) {
            sum += gas[i] - cost[i];
            /*
              If car starts at A and can not reach B. Any station between A and B
              can not reach B.(B is the first station that A can not reach.)
             */
            if (sum < 0) {
                total += sum;
                sum = 0;
                res = i + 1;
            }
        }
        total += sum;
        // If the total number of gas is bigger than the total number of cost. There must be a solution.
        return total < 0 ? -1 : res;
    }
}
