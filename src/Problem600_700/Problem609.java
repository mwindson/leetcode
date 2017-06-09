package Problem600_700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mwindson on 2017/6/9.
 * https://leetcode.com/problems/find-duplicate-file-in-system/#/description
 */
public class Problem609 {
    public static void main(String[] args) {
        String[] path = {"root/a 1.txt(abcd) 2.txt(efgh) 3.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println(findDuplicate(path));
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> pathMap = new HashMap<>();
        for (String path1 : paths) {
            String[] path = path1.split(" ");
            String pathName = path[0];
            for (int j = 1; j < path.length; j++) {
                int left = path[j].indexOf('(');
                int right = path[j].indexOf(')');
                if (left == -1 || right == -1) continue;
                String fileName = path[j].substring(0, left);
                String content = path[j].substring(left + 1, right);
                List<String> filePaths = pathMap.getOrDefault(content, new ArrayList<>());
                filePaths.add(pathName + '/' + fileName);
                pathMap.put(content, filePaths);
            }
        }
        for (String s : pathMap.keySet()) {
            if (pathMap.get(s).size() >= 2) result.add(new ArrayList<>(pathMap.get(s)));
        }
        return result;
    }
}
