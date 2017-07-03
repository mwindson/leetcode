package Problem600_700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mwindson on 2017/7/3.
 * https://leetcode.com/problems/design-log-storage-system/#/description
 */
public class Problem635 {
    public static void main(String[] args) {
        LogSystem obj = new LogSystem();
        obj.put(1, "2017:01:01:23:59:59");
        obj.put(2, "2017:01:01:22:59:59");
        obj.put(3, "2016:01:01:00:00:00");
        System.out.println(obj.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year"));
        System.out.println(obj.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour"));
    }

    public static class LogSystem {
        Map<Integer, String> logMap;

        public LogSystem() {
            logMap = new HashMap<>();
        }

        public void put(int id, String timestamp) {
            logMap.put(id, timestamp);
        }

        public List<Integer> retrieve(String s, String e, String gra) {
            int x = 0;
            switch (gra) {
                case "Year":
                    x = 4;
                    break;
                case "Month":
                    x = 7;
                    break;
                case "Day":
                    x = 10;
                    break;
                case "Hour":
                    x = 13;
                    break;
                case "Minute":
                    x = 16;
                    break;
                case "Second":
                    x = 19;
                    break;
            }
            s = s.substring(0, x);
            e = e.substring(0, x);
            List<Integer> ans = new ArrayList<>();
            for (Integer i : logMap.keySet()) {
                String ss = logMap.get(i).substring(0, x);
                if (ss.compareTo(s) >= 0 && ss.compareTo(e) <= 0) ans.add(i);
            }
            return ans;
        }
    }
}
