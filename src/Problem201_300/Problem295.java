package Problem201_300;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by mwindson on 2017/9/20.
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 */
public class Problem295 {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(4);
        System.out.println(obj.findMedian());
        obj.addNum(8);
        System.out.println(obj.findMedian());

    }

    static class MedianFinder {
        // 右半边的大小总是大于或等于右半边
        PriorityQueue<Integer> max;
        PriorityQueue<Integer> min;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            max = new PriorityQueue(1000, Collections.reverseOrder());
            min = new PriorityQueue<>();
        }

        public void addNum(int num) {
            max.offer(num);
            min.offer(max.poll());
            if (max.size() < min.size())
                max.offer(min.poll());
        }

        public double findMedian() {
            return max.size() == min.size() ? (max.peek() + min.peek()) / 2.0 : max.peek();
        }
    }
}
