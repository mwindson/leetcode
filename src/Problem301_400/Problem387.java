package Problem301_400;

/**
 * Created by Administrator on 2016/12/15.
 */
public class Problem387 {
    public static void main(String[] args) {
        String s = "aabccc";
        System.out.print(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        int[] counts=new int[26];
        // store the number of evert character
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i ++)
            if(counts [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
