package Problem001_100;

/**
 * Created by mwindson on 2017/1/31.
 * Questions: https://leetcode.com/problems/climbing-stairs/
 */
public class Problem070 {
    public static void main(String[] args) {
        System.out.println(climbStairs(27));
    }

    public static int climbStairs(int n) {
        if(n == 0 || n == 1 || n == 2){return n;}
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;
        for(int i = 2; i < n; i++){
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[n-1];
    }
}
