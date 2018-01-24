package Problem701_800;

import java.util.Arrays;
import java.util.Stack;

/**
 * 735. Asteroid Collision
 * https://leetcode.com/problems/asteroid-collision/description/
 *
 * @ tag stack
 */
public class Problem735 {
    public static void main(String[] args) {
        int[] asteroids = {-2, 1, 1, -1};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.empty()) {
                stack.push(asteroids[i]);
            } else {
                int top = stack.peek();
                if (top < 0 || (top > 0 && asteroids[i] > 0)) {
                    stack.push(asteroids[i]);
                } else if (top > 0 && asteroids[i] < 0) {
                    boolean needPush = true;
                    while (!stack.isEmpty() && stack.peek() > 0) {
                        if (stack.peek() + asteroids[i] == 0) {
                            stack.pop();
                            needPush = false;
                            break;
                        } else if (stack.peek() + asteroids[i] < 0) {
                            stack.pop();
                        } else {
                            needPush = false;
                            break;
                        }
                    }
                    if (needPush) stack.push(asteroids[i]);
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
