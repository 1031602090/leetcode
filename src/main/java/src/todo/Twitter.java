package todo;

import java.util.*;

public class Twitter {

    private Map<Long, Integer> tweets;
    private Map<Integer, Set<Integer>> users;
    private Map<Integer, Set<Integer>> usersTweets;
    private long id = 1;
    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        tweets = new TreeMap<>(((o1, o2) -> (int) (o2 - o1)));
        users = new HashMap<>();
        usersTweets = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId))
            initUser(userId);
        usersTweets.putIfAbsent(userId, new HashSet<>());
        tweets.put(id++, tweetId);
        usersTweets.get(userId).add(tweetId);
    }

    private void initUser(int userId) {
        users.put(userId,new HashSet<>());
        usersTweets.put(userId,new HashSet<>());
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId))
            return List.of();
        Set<Integer> followeeList = users.get(userId);
        List<Integer> feeds = new ArrayList<>(10);
        for (Long time : tweets.keySet()) {
            Integer feed = tweets.get(time);
            if (feeds.size() < 10 && usersTweets.get(userId).contains(feed)) {
                feeds.add(feed);
                continue;
            }
            for (Integer followee : followeeList) {
                if (feeds.size() < 10 && usersTweets.get(followee).contains(feed)) {
                    feeds.add(feed);
                }
            }
            if (feeds.size() == 10)
                break;
        }
        return feeds;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId))
            initUser(followerId);
        if (!users.containsKey(followeeId))
            initUser(followeeId);

        users.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        users.get(followerId).remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        twitter.postTweet(1, 2);
        twitter.follow(1,1);
//        twitter.unfollow(2,1);
        System.out.println(twitter.getNewsFeed(1));
    }
}
