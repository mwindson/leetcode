package Problem701_800;

import java.util.TreeMap;

public class Problem732 {
    static class MyCalendarThree {
        private TreeMap<Integer, Integer> timeline = new TreeMap<>();

        // each start add a new ongoing event at that time, each end terminate an ongoing event.
        //   10    20
        //   10                   60
        //                   50   60
        //   10         40
        // 5     15
        // 5 10
        //            25        55
        public int book(int s, int e) {
            timeline.put(s, timeline.getOrDefault(s, 0) + 1); // 1 new event will be starting at [s]
            timeline.put(e, timeline.getOrDefault(e, 0) - 1); // 1 new event will be ending at [e];
            int ongoing = 0, k = 0;
            for (int v : timeline.values())
                k = Math.max(k, ongoing += v);
            return k;
        }
    }

    public static void main(String[] args) {
        MyCalendarThree obj = new MyCalendarThree();
        System.out.println(obj.book(10, 20));
        System.out.println(obj.book(50, 60));
        System.out.println(obj.book(10, 40));
        System.out.println(obj.book(5, 15));
        System.out.println(obj.book(5, 10));
        System.out.println(obj.book(25, 55));
    }
}
