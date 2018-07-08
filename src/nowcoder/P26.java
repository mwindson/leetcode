package nowcoder;

import java.util.ArrayList;

public class P26 {
    public static void main(String[] args) {
        String[] ss = {"", "aa", "aabb", "abc"};
        for (String s : ss) {
            System.out.println(new P26().Permutation(s));
        }
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str.length() == 0) return list;
        boolean[] used = new boolean[str.length()];
        helper(list, str, "", used);
        return list;
    }

    private void helper(ArrayList<String> list, String str, String curr, boolean[] used) {
        if (curr.length() == str.length()) {
            if (!list.contains(curr)) list.add(curr);
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (!used[i]) {
                    used[i] = true;
                    helper(list, str, curr + str.charAt(i), used);
                    used[i] = false;
                }
            }
        }
    }
}
