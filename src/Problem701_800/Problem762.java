package Problem701_800;

/**
 * Created by mwindson on 2018/1/22.
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/
 */
public class Problem762 {
    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10));
    }

    public static int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = L; i <= R; i++) {
            if (isPrime(Integer.bitCount(i))) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        boolean isPrime = true;
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
