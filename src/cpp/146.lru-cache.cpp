/*
 * @lc app=leetcode id=146 lang=cpp
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (40.07%)
 * Likes:    13399
 * Dislikes: 537
 * Total Accepted:    1.1M
 * Total Submissions: 2.7M
 * Testcase Example:
 '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design a data structure that follows the constraints of a Least Recently
 * Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size
 * capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise
 * return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache. If the number of keys
 * exceeds the capacity from this operation, evict the least recently used
 * key.
 *
 *
 * The functions get and put must each run in O(1) average time complexity.
 *
 *
 * Example 1:
 *
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 10^4
 * 0 <= value <= 10^5
 * At most 2 * 10^5 calls will be made to get and put.
 *
 *
 */

// @lc code=start
class LRUCache {
public:
  using Iter = list<pair<int, int>>::iterator;

  LRUCache(int capacity) { capacity_ = capacity; }

  int get(int key) {
    if (kv_.count(key) == 0) {
      return -1;
    }
    Iter list_iter = kv_[key];
    pair<int, int> key_val = *list_iter;
    list_.erase(list_iter);

    list_.emplace_front(key_val);
    kv_[key] = list_.begin();
    return key_val.second;
  }

  void put(int key, int value) {
    pair<int, int> new_kv = make_pair(key, value);
    list_.emplace_front(new_kv);
    if (kv_.count(key) == 0) {
      if (list_.size() > capacity_) {
        pair<int, int> kv = list_.back();
        kv_.erase(kv.first);
        list_.pop_back();
      }
    } else {
      Iter list_iter = kv_[key];
      pair<int, int> key_val = *list_iter;
      list_.erase(list_iter);

    }
    kv_[key] = list_.begin();
  }

private:
  int capacity_{0};
  unordered_map<int, Iter> kv_;
  list<pair<int, int>> list_;
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
// @lc code=end
