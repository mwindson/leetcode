package Problem301_400;

import java.util.*;

/**
 * Created by mwindson on 2017/6/4.
 * https://leetcode.com/problems/insert-delete-getrandom-o1/#/description
 */
public class Problem380 {
    public static void main(String[] args) {
        RandomizedSet randomSet = new RandomizedSet();
        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomSet.insert(1));

        // Returns false as 2 does not exist in the set.
        System.out.println(randomSet.remove(2));

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomSet.insert(2));

        // getRandom should return either 1 or 2 randomly.
        System.out.println(randomSet.getRandom());

        // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomSet.remove(1));

        // 2 was already in the set, so return false.
        System.out.println(randomSet.insert(2));

        // Since 2 is the only number in the set, getRandom always return 2.
        System.out.println(randomSet.getRandom());
    }

    public static class RandomizedSet {
        List<Integer> list;
        Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            list = new ArrayList<>();
            random = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (list.contains(val)) {
                return false;
            }
            return list.add(val);
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (list.indexOf(val) == -1) {
                return false;
            }
            list.remove(list.indexOf(val));
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int index = random.nextInt(list.size());
            return list.get(index);
        }
    }
}
