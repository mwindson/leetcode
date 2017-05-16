package Problem301_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mwindson on 2017/5/15.
 * https://leetcode.com/problems/design-twitter/#/description
 */
public class Problem355 {
    public static class Twitter {
        List<Map<Integer, Integer>> twitters;
        Map<Integer, List<Integer>> follow;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            follow = new HashMap<>();
            twitters = new ArrayList<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            Map<Integer, Integer> tweet = new HashMap<>();
            tweet.put(userId, tweetId);
            twitters.add(tweet);
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> news = new ArrayList<>();
            List<Integer> followee = follow.getOrDefault(userId, new ArrayList<>());
            for (int i = twitters.size() - 1; i >= 0; i--) {
                Map<Integer, Integer> map = twitters.get(i);
                if (news.size() >= 10) {
                    break;
                }
                for (Integer id : map.keySet()) {
                    if (id == userId || followee.contains(id)) {
                        news.add(map.get(id));
                    }
                }
            }
            return news;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            List<Integer> tmpList = follow.getOrDefault(followerId, new ArrayList<>());
            tmpList.add(followeeId);
            follow.put(followerId, tmpList);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            List<Integer> tmpList = follow.getOrDefault(followerId, new ArrayList<>());
            if (tmpList.contains(followeeId))
                tmpList.remove(tmpList.indexOf(followeeId));
            follow.put(followerId, tmpList);
        }
    }

    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */
    public static void main(String[] args) {
        Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
//        System.out.println(twitter.getNewsFeed(1));

// User 1 follows user 2.
        twitter.follow(1, 2);
        twitter.follow(2, 1);
        System.out.println(twitter.getNewsFeed(2));

// User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getNewsFeed(2));

// User 1 unfollows user 2.
        twitter.unfollow(2, 1);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getNewsFeed(2));

        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getNewsFeed(2));
    }
}
