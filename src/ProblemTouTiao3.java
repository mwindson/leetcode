import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mwindson on 2017/3/30.
 */
// 括号
public class ProblemTouTiao3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        print(input);
    }

    public static void print(String input) {
        Stack<Character> s = new Stack<>();
        Stack<String> s2 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int level = 0;
        int maxLevel = 0;
        int maxLevel2 = 0;
        s.push(input.charAt(0));
        list.add(level);
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == '[') {
                level++;
                s.push(input.charAt(i));
                list.add(level);
                maxLevel = Math.max(maxLevel, level);
                maxLevel2 = Math.max(maxLevel2, maxLevel);
            } else if (input.charAt(i) == ']') {
                s.pop();
                list.add(level);
                level--;
            }
            if (s.isEmpty()) {
                print(list, maxLevel, maxLevel2);
                list = new ArrayList<>();
                maxLevel = 0;
            }

        }

    }

    private static void print(List<Integer> list, int maxLevel, int maxLevel2) {
        for (int i = 0; i < list.size(); i++) {
            int diff = maxLevel - list.get(i);
            // + 个数
            int num1 = 2;
            // | 个数
            int num2 = diff == maxLevel ? 0 : 2;
            // - 个数
            int num3 = (maxLevel2 - (maxLevel - diff)) * 2 + 1;
            // space 个数
            int num4 = maxLevel2 * 2 + 1 - num3 - num2;
            String out = "";
            for (int j = num3; j > 0; j--)
                out += "-";
            out = "+" + out + "+";
            for (int j = num2; j > 0; j -= 2)
                out = "|" + out + "|";
            for (int j = num4; j > 0; j -= 2)
                out = " " + out + " ";
            String out2 = " ";
            String out3 = "";
            for (int j = 0; j < maxLevel2 * 2 + 1; j++)
                out3 += "";
            if (diff == 0) {
                for (int j = maxLevel2 - maxLevel; j > 0; j--)
                    out2 = " " + out2 + " ";
                out2 = "|" + out2 + "|";
                for (int j = maxLevel; j > 0; j--)
                    out2 = " " + out2 + " ";
                System.out.println(out);
                System.out.println(out2);
                System.out.println(out3);
                System.out.println(out2);
                System.out.println(out);
                i++;
            } else {
                System.out.println(out);
            }
        }
    }
}
