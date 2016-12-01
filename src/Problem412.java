import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/12/1.
 */
public class Problem412 {
    public List<String> fizzBuzz(int n) {
        List<String> FBList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                FBList.add("FizzBuzz");
            } else if (i % 3 == 0 && i % 5 != 0) {
                FBList.add("Fizz");
            } else if (i % 3 != 0 && i % 5 == 0) {
                FBList.add("Buzz");
            } else {
                FBList.add("" + i);
            }
        }
        return FBList;
    }

    public void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int inputNumber = in.nextInt();
        this.fizzBuzz(inputNumber);
    }
}
