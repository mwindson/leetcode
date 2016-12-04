/**
 * Created by Administrator on 2016/12/4.
 */
public class Problem258 {
    public int addDigits(int num) {
        int DigitsSum = 0;
        if (num == 0) {
            DigitsSum = 0;
        } else if (num % 9 == 0) {
            DigitsSum = 9;
        } else {
            DigitsSum = num % 9;
        }
        return DigitsSum;
    }
}
