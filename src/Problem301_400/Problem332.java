package Problem301_400;

import java.util.*;

/**
 * Created by mwindson on 2017/6/27.
 * https://leetcode.com/problems/reconstruct-itinerary/#/description
 */
public class Problem332 {
    public static void main(String[] args) {
        String[][] tickets = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        System.out.println(findItinerary(tickets));
    }

    public static List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        List<String> route = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
                stack.push(targets.get(stack.peek()).poll());
            route.add(0, stack.pop());
        }
        return route;
    }
}
