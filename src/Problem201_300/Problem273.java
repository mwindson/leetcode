package Problem201_300;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by mwindson on 2017/4/9.
 * https://leetcode.com/problems/integer-to-english-words/#/description
 */
public class Problem273 {
    public static void main(String[] args) {
        int[] nums = {1000010, 1000100000};
        for (int num : nums) {
            System.out.println(numberToWords(num));
        }
    }

    public static String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        // 0-19
        String[] map1 = {
                "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };
        // 20-90
        String[] map2 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        // billion-thousand
        String[] map3 = {"", "Thousand", "Million", "Billion"};
        List<String> word = new ArrayList<>();
        StringBuilder words = new StringBuilder();
        String numS = String.valueOf(num);
        int count = numS.length() / 3;
        int rest = numS.length() % 3;
        if (rest == 0) {
            count--;
            rest = 3;
        }
        int index = 0;
        while (count >= 0) {
            if (rest == 3) {
                if (numS.charAt(index) != '0') {
                    word.add(map1[numS.charAt(index) - '0']);
                    word.add("Hundred");
                }
                index++;
                rest--;
            }
            if (rest == 2) {
                if (numS.charAt(index) >= '2') {
                    word.add(map2[numS.charAt(index) - '0']);
                    index++;
                    rest--;
                } else if (numS.charAt(index) == '1') {
                    word.add(map1[Integer.valueOf(numS.substring(index, index + 2))]);
                    index += 2;
                } else {
                    index++;
                    rest--;
                }
            }
            if (rest == 1) {
                if (numS.charAt(index) != '0') {
                    word.add(map1[numS.charAt(index) - '0']);
                }
                index++;
            }
            if (!(Objects.equals(word.get(word.size() - 1), map3[1]) || Objects.equals(word.get(word.size() - 1), map3[2]) || Objects.equals(word.get(word.size() - 1), map3[3])))
                word.add(map3[count]);
            rest = 3;
            count--;
        }
        for (int j = 0; j < word.size(); j++) {
            words.append(word.get(j));
            if (j != word.size() - 1 && !Objects.equals(word.get(j + 1), "")) words.append(' ');
        }
        return words.toString();
    }
}
