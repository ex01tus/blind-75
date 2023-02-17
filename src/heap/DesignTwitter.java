package heap;

import java.util.*;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;

/**
 * Description: https://leetcode.com/problems/design-twitter
 * Difficulty: Medium
 * Time complexity: O(1) for post(), follow() and unfollow(), O(nlog n) for getNews()
 * Space complexity: O(n)
 */
public class DesignTwitter {

    private static class Twitter {

        private static final int NEWS_FEED_SIZE_LIMIT = 10;

        private final Map<Integer, Set<Integer>> followMap;
        private final Map<Integer, List<Tweet>> tweetMap;

        private long currentTime;

        public Twitter() {
            followMap = new HashMap<>();
            tweetMap = new HashMap<>();
            currentTime = 0;
        }

        public void postTweet(int userId, int tweetId) {
            tweetMap.computeIfAbsent(userId, __ -> new ArrayList<>())
                    .add(new Tweet(tweetId, currentTime++));
        }

        public List<Integer> getNewsFeed(int userId) {
            Queue<Tweet> tweetHeap = buildTweetHeap(userId);
            return prepareNewsFeed(tweetHeap);
        }

        public void follow(int followerId, int followeeId) {
            followMap.computeIfAbsent(followerId, __ -> new HashSet<>())
                    .add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            followMap.getOrDefault(followerId, emptySet())
                    .remove(followeeId);
        }

        private Queue<Tweet> buildTweetHeap(int userId) {
            Queue<Tweet> tweetHeap = new PriorityQueue<>((t1, t2) -> Long.compare(t2.timestamp, t1.timestamp));

            Set<Integer> followees = followMap.getOrDefault(userId, new HashSet<>());
            followees.add(userId); // user is always the follower of himself

            for (int followee : followees) {
                tweetHeap.addAll(tweetMap.getOrDefault(followee, emptyList()));
            }

            return tweetHeap;
        }

        private List<Integer> prepareNewsFeed(Queue<Tweet> tweetHeap) {
            List<Integer> newsFeed = new ArrayList<>();
            while (!tweetHeap.isEmpty() && newsFeed.size() < NEWS_FEED_SIZE_LIMIT) {
                newsFeed.add(tweetHeap.poll().tweetId);
            }

            return newsFeed;
        }

        private static class Tweet {

            private final int tweetId;
            private final long timestamp; // tweetId can be used instead

            public Tweet(int tweetId, long timestamp) {
                this.tweetId = tweetId;
                this.timestamp = timestamp;
            }
        }
    }
}
