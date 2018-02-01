package Problem600_700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 638. Shopping Offers
 * https://leetcode.com/problems/shopping-offers/description/
 *
 * @ tag dp
 */
public class Problem638 {
    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(2, 5);
        List<List<Integer>> special = Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10));
        List<Integer> needs = Arrays.asList(3, 2);
        System.out.println(shoppingOffers(price, special, needs));
    }

    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return helper(price, special, needs, 0);
    }

    private static int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {
        int local_min = direct_purchase(price, needs);
        for (int i = pos; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < needs.size(); j++) {
                if (needs.get(j) < offer.get(j)) {
                    tmp = null;
                    break;
                }
                tmp.add(needs.get(j) - offer.get(j));
            }
            if (tmp != null) {
                local_min = Math.min(local_min, offer.get(offer.size() - 1) + helper(price, special, tmp, i));
            }
        }
        return local_min;
    }

    private static int direct_purchase(List<Integer> price, List<Integer> needs) {
        int sum = 0;
        for (int i = 0; i < price.size(); i++) {
            sum += price.get(i) * needs.get(i);
        }
        return sum;
    }
}
