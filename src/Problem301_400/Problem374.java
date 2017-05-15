package Problem301_400;

/**
 * Created by mwindson on 2017/5/15.
 * https://leetcode.com/problems/guess-number-higher-or-lower/#/description
 */
public class Problem374 {
    static int number = 1702766719;

    public static void main(String[] args) {
        System.out.println(guessNumber(2126753390));
    }

    /* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
    public static int guessNumber(int n) {
        int i = 1, j = n;
        while(i < j) {
            // 不能用(i+j)/2 因为会溢出
            int mid = i + (j - i) / 2;
            if(guess(mid) == 0) {
                return mid;
            } else if(guess(mid) == 1) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    private static int guess(int num) {
        if (num == number) {
            return 0;
        } else {
            return num > number ? -1 : 1;
        }
    }
}
