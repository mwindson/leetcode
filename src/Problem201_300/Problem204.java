package Problem201_300;

/**
 * Created by mwindson on 2017/3/26.
 * https://leetcode.com/problems/count-primes/#/description
 */
public class Problem204 {
    public static void main(String[] args) {
        System.out.println(countPrimes(50));
    }

    // 2为质数，则2*j的数都不是质数，依次类推3,5,7
    public static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }

        return count;
    }
}
