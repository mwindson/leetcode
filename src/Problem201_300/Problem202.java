package Problem201_300;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mwindson on 2017/1/30.
 * Question: https://leetcode.com/problems/happy-number/
 */
public class Problem202 {
    public static void main(String[] args) {
        int num = 1;
        System.out.println(isHappy(num));
    }

//    O(1) but will take more time for the loop
//    x increase one ,y increase two,if has a loop ,x and y will in same position
//    public boolean isHappy(int n) {
//        int x = n;
//        int y = n;
//        while(x>1){
//            x = cal(x) ;
//            if(x==1) return true ;
//            y = cal(cal(y));
//            if(y==1) return true ;
//
//            if(x==y) return false;
//        }
//        return true ;
//    }
//    public int cal(int n){
//        int x = n;
//        int s = 0;
//        while(x>0){
//            s = s+(x%10)*(x%10);
//            x = x/10;
//        }
//        return s ;
//    }
    public static boolean isHappy(int n) {
        Set<Integer> s = new HashSet<Integer>();
        while (n != 1) {
            if (!s.add(n)) {
                return false;
            }
            n = countNextNum(n);
        }
        return true;
    }

    private static int countNextNum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += Math.pow(num % 10, 2);
            num /= 10;
        }
        return sum;
    }
}
