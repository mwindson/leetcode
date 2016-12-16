package Problem001_100;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/11/22.
 */
public class Problem006 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int numRows = in.nextInt();
        System.out.print(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        String ns = "";
        int length = s.length();
        if(numRows==1) return s;
        int col = length / (2 * numRows - 2);
        int row = length % (2 * numRows - 2);

        for (int i = 0; i < numRows; i++) {
            int n = 0;
            for (int j = 0; j <= col; j++) {
                ns += s.charAt(2 * (numRows - 1) * j + i);
                if ((i != 0) && (i != numRows - 1)) {
                    if ((2 * (numRows - 1) * j + i + 2 * (numRows - 1 - i))<length){
                        ns += s.charAt(2 * (numRows - 1) * j + i + 2 * (numRows - 1 - i));
                    }
                }
            }
        }

        return ns;
    }
}
