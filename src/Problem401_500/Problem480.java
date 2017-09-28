package Problem401_500;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by mwindson on 2017/9/20.
 * https://leetcode.com/problems/sliding-window-median/description/
 */
public class Problem480 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2,3,1,4,2};
        System.out.println(Arrays.toString(medianSlidingWindow(nums, 3)));
    }

    static Queue<Integer> minHeap = new PriorityQueue<>();
    static Queue<Integer> maxHeap = new PriorityQueue<>(1, Collections.reverseOrder());

    public static double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] medians = new double[n - k + 1];

        for (int i = 0; i < nums.length; ++i) {
            addNum(nums[i]);
            if (i - k >= 0) {
                removeNum(nums[i - k]);
            }
            if (i - k + 1 >= 0) {
                medians[i - k + 1] = getMedian();
            }
        }

        return medians;
    }

    private static void addNum(int n) {
        if (minHeap.isEmpty()) {
            minHeap.offer(n);
            return;
        } else if (minHeap.peek() <= n) {
            minHeap.offer(n);
        } else {
            maxHeap.offer(n);
        }
        balance();
    }

    private static void removeNum(int n) {
        if (minHeap.peek() <= n) {
            minHeap.remove(n);
        } else {
            maxHeap.remove(n);
        }
        balance();
    }

    private static void balance() {
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        } else if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    private static double getMedian() {
        return minHeap.size() == maxHeap.size() ? ((double) minHeap.peek() + maxHeap.peek()) / 2 : minHeap.peek();
    }
}
