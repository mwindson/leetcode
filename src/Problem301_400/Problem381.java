package Problem301_400;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mwindson on 2017/6/4.
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/#/description
 */
public class Problem381 {
    public static void main(String[] args) {

    }

    public static class RandomizedCollection {
        List<Integer> list;
        Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            list = new ArrayList<>();
            random = new Random();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (list.contains(val)) {
                list.add(val);
                return false;
            }
            list.add(val);
            return true;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (list.indexOf(val) == -1) {
                return false;
            }
            list.remove(list.indexOf(val));
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            int index = random.nextInt(list.size());
            return list.get(index);
        }
    }
}
