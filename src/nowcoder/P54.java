package nowcoder;

import java.util.LinkedList;
import java.util.Queue;

public class P54 {
    //Insert one char from stringstream
    int[] counts = new int[256];
    Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        counts[(int) ch]++;
        if (counts[(int) ch] == 1) {
            queue.add(ch);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        while (!queue.isEmpty() && counts[queue.peek()] > 1) {
            queue.poll();
        }
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
