package Problem301_400;

/**
 * Created by mwindson on 2017/5/12.
 * https://leetcode.com/problems/super-ugly-number/#/description
 */
public class Problem313 {
    public static void main(String[] args) {
        int n = 10;
        int[] primes = {2, 7, 13, 19};
        System.out.println(nthSuperUglyNumber(n, primes));
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        // super ugly numbers
        int[] superUgly = new int[n];
        superUgly[0] = 1;
        //  each primes result
        int[] factor = new int[primes.length];
        // each primes result index of super ugly numbers array
        int[] index = new int[primes.length];
        for (int i = 0; i < primes.length; i++) {
            factor[i] = primes[i];
        }
        for (int i = 1; i < n; i++) {
            int min = factor[0];
            for (int j = 1; j < primes.length; j++) {
                min = Math.min(min, factor[j]);
            }
            superUgly[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (factor[j] == min) {
                    index[j]++;
                    factor[j] = primes[j] * superUgly[index[j]];
                }
            }
        }
        return superUgly[n - 1];
    }
}
